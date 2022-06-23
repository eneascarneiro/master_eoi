package utils;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Random;

public class token {
    private static String token;
    private static String usuario;
    public token() {
    }

    public static String generateRandomToken(int len,String usr) {
        if (token != null && token.length() > 1) {
            return token;
        } else {
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                    +"lmnopqrstuvwxyz!@#$%&"+usuario;
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            token = sb.toString();
            usuario = usr;
            return token;
        }
    }
    public static boolean ValidarSesion(HttpServletRequest request){
        //Creamos una cookie de sesion
        HttpSession session = request.getSession();
        //obtenemos el usuario de la sesion
        if  (session.getAttribute ("usuario") == null || session.getAttribute ("usuario") == ""){
            return false;
        }
        else {
            //Comprobamos el token
            //Hay token?
            if (session.getAttribute("token") == null || session.getAttribute("token") == "") {
                return false;
            } else {
                if (session.getAttribute("token") == token) {
                    return true;
                }
            }
        }
        return true;
    }
    public static void CerrarSeion(HttpServletRequest request) {
        //Creamos una cookie de sesion
        HttpSession session = request.getSession();
        //eliminamos el token
        session.removeAttribute("token");
        session.removeAttribute("usuario");

    }

    public static String getUsuario() {
        return usuario;
    }
}