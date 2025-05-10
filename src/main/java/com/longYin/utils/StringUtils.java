package com.longYin.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUtils {

    /**
     * 纯净字符串函数，过滤特殊符号和空格
     * @param theString
     * @return
     */
    public static String pureString(String theString){
        // 去掉特殊字符和空格
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(theString);
        theString = matcher.replaceAll("");
        return theString;
    }

    /**
     * 判断字符串是否为空
     * @param str 待检查的字符串
     * @return 如果字符串为null或其长度为0，返回true；否则返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
