package com.example.demo.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordHadling  {
    private static BCryptPasswordEncoder encoder;


    public static String CodePassword(String psw) {
        return encoder.encode(psw);
    }
    //Crear metodo para validar password

}
