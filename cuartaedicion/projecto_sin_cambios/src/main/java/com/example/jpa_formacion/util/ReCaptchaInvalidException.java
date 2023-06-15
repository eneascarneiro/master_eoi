package com.example.jpa_formacion.util;

public class ReCaptchaInvalidException extends Exception{
    public ReCaptchaInvalidException(String message) {
        super(message);
    }
}
