package com.example.jpa_formacion.util;

public class InvalidReCaptchaException extends Exception{
    public InvalidReCaptchaException(String message) {
        super(message);
    }
}
