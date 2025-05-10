package com.longYin.utils;

import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class PrintUtils {
    private static PrintWriter writer;

    static {
        try {
            // 创建PrintWriter对象，使用UTF-8编码输出
            writer = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void print(Object obj) {
        writer.println(obj);
    }

    public static void printWithBreakpoint(Object obj) {
        writer.println("=== 调试信息 ===");
        writer.println(obj);
        writer.println("===================");
    }
}
