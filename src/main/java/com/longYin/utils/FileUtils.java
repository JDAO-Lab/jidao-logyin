package com.longYin.utils;

public class FileUtils {

    // 获取文件后缀名
    public static String getFileSuffix(String fileName) {
        if (fileName != null && fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    // 检测文件类型是否在限制范围内
    public static boolean isFileTypeAllowed(String fileName, String allowedSuffixes) {
        String fileSuffix = getFileSuffix(fileName);
        if (allowedSuffixes.contains(fileSuffix)) {
            return true;
        }
        return false;
    }


}