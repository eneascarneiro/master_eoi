package utils;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class CookiesInternas {

    public CookiesInternas() {
    }
    public static void  crearcookie(HttpServletResponse response, String nombre, String contenido) {
        Cookie co = new Cookie(nombre, contenido);
        co.setMaxAge(30);
        response.addCookie(co);
    }

    public static void  modificarcookie(HttpServletRequest request,HttpServletResponse response, String nombre , String contenido) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName() == nombre ){
                Cookie micookie = cookies[i];
                micookie.setValue(contenido);
                response.addCookie(micookie);
            }
        }
    }

    public static void  eliminarcookie(HttpServletRequest request,HttpServletResponse response,String nombre ) {
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName() == nombre ){
                Cookie micookie = cookies[i];
                micookie.setValue("");
                micookie.setPath("/");
                micookie.setMaxAge(0);
                response.addCookie(micookie);
            }
        }
    }
    public static List<Cookie> Listarcookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        return Arrays.asList(cookies);
    }
}
