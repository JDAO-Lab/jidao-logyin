package com.longYin;


import com.longYin.utils.SmsUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmsTests {

    @Autowired
    private SmsUtils smsUtils;

    @Test
    void getConfig(){
        System.out.println(smsUtils.getAccessKey());
        System.out.println(smsUtils.getSecretKey());
        System.out.println(smsUtils.getEndpoint());
        System.out.println(smsUtils.getSignName());
        System.out.println(smsUtils.getTemplateCode());
    }

    @Test
    void testSendCode() throws Exception {
        smsUtils.sendCode("18511092960", "8886");
    }
}
