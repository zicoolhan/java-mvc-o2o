package com.czh.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request) {
        String veryfyCodeExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        String veryfyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");

        if (veryfyCodeActual == null || !veryfyCodeActual.equals(veryfyCodeExpected)) {
            return false;
        }
        return true;
    }
}
