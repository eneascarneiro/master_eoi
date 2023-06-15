package com.example.jpa_formacion.service;

import com.example.jpa_formacion.model.Usuario;
import com.example.jpa_formacion.util.InvalidReCaptchaException;
import com.example.jpa_formacion.util.ReCaptchaInvalidException;

public interface ICaptchaServicio {
    public void processResponse(String response) throws InvalidReCaptchaException, ReCaptchaInvalidException;
    public String getReCaptchaSecret();
}
