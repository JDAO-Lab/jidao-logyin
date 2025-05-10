package com.longYin.utils;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.longYin.config.SmsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aliyun.dysmsapi20170525.Client;

import java.util.Objects;

@Slf4j
@Component
public class SmsUtils {

    @Autowired
    private SmsConfig smsConfig;

    //获取accessKey
    public String getAccessKey() {
        return smsConfig.getAccessKey();
    }

    //获取secretKey
    public String getSecretKey() {
        return smsConfig.getSecretKey();
    }

    //获取短信节点
    public String getEndpoint() {
        return smsConfig.getEndpoint();
    }

    //获取签名
    public String getSignName() {
        return smsConfig.getSignName();
    }

    //获取验证码模板
    public String getTemplateCode() {
        return smsConfig.getTemplateCode();
    }

    /**
     * 使用 AK&ASK 初始化账号 Client
     */
    public Client createClient() throws Exception {
        Config config = new Config().setAccessKeyId(getAccessKey()).setAccessKeySecret(getSecretKey());
        config.endpoint = getEndpoint();
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    /**
     * 发送短信验证码
     *
     * @param phone 电话号码
     * @throws Exception 短信推送异常
     */
    public boolean sendCode(String phone, String code) throws Exception {
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS
        Client client = createClient();
        SendSmsRequest sendSmsRequest =
                new SendSmsRequest()
                        .setSignName(getSignName())
                        .setTemplateCode(getTemplateCode())
                        .setPhoneNumbers(phone)
                        .setTemplateParam("{\"code\":\"" + code + "\"}");
        try {
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse sendSmsResponse = client.sendSms(sendSmsRequest);
            //转为json字符串输出
            log.info("短信推送结果: " + JsonUtils.objectToJson(sendSmsResponse.getBody()));
            if (Objects.nonNull(sendSmsResponse) && sendSmsResponse.getBody().code.equals("OK")) {
                log.info("短信推送成功结果: " + JsonUtils.objectToJson(sendSmsResponse.getBody()));
                return true;
            }
        } catch (TeaException error) {
            // 如有需要，请打印 error
            log.error("短信推送异常结果: " + JsonUtils.objectToJson(error.message));
            return false;
        } catch (Exception e) {
            TeaException error = new TeaException(e.getMessage(), e);
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
            log.error("短信推送异常结果: " + JsonUtils.objectToJson(error.message));
            return false;
        }
        return false;
    }

}
