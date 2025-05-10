package com.longYin;

import com.longYin.utils.PrintUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LogYinApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogYinApplication.class, args);
        PrintUtils.print("LogYi Admin is runing~~");
    }

}
