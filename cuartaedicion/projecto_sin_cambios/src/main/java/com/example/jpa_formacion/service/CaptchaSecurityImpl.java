package com.example.jpa_formacion.service;



import com.example.jpa_formacion.util.CaptchaSettings;
import com.example.jpa_formacion.util.GoogleResponse;
import com.example.jpa_formacion.util.InvalidReCaptchaException;
import com.example.jpa_formacion.util.ReCaptchaInvalidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class CaptchaSecurityImpl implements ICaptchaServicio {

    @Autowired
    private CaptchaSettings captchaSettings;
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    private RestOperations restTemplate;

    private static Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    @Override
    public void processResponse(String response) throws InvalidReCaptchaException, ReCaptchaInvalidException {
        if(!responseSanityCheck(response)) {
            throw new InvalidReCaptchaException("Response contains invalid characters");
        }
        //Comprobamos captcha
        URI verifyUri = URI.create(String.format(
                "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
                getReCaptchaSecret(), response, getClientIP()));
        GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);

        if(!googleResponse.isSuccess()) {
            throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
        }
    }
    private boolean responseSanityCheck(String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    @Override
    public String getReCaptchaSecret() {
        return captchaSettings.getSecret();
    }

    protected String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null || xfHeader.isEmpty() || !xfHeader.contains(request.getRemoteAddr())) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}


