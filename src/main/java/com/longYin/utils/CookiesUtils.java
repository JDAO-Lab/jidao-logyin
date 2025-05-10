package com.longYin.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtils {

    // 设置Cookie
    public static void setCookie(String name, String value, int maxAge, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/"); // 设置路径
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    // 通过name读取前端Cookie的值
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
//                    PrintUtils.print("Cookie："+name);
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void destroyCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setMaxAge(0); // 将cookie的有效期设置为0，立即失效
                    cookie.setPath("/"); // 设置cookie的路径，确保能够正确删除
                    response.addCookie(cookie); // 更新响应，删除对应的cookie
                    break;
                }
            }
        }
    }
}
