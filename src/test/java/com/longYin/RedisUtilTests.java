package com.longYin;

import com.longYin.config.RedisConfig;
import com.longYin.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisUtilTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisConfig redisConfig;

    @Test
    public void testSetRedis(){
        redisUtil.setValue("ren", "1000000000000000000000000000");
    }

    @Test
    public void testGetRedis(){
        String one = redisUtil.getValue("ren");
        System.out.print(one);
    }

    @Test
    public void testIsRedis(){
        redisUtil.isHashKey("ren");
    }

    @Test
    public void testDelRedis(){
        redisUtil.deleteKey("ren");
    }

    @Test
    //获取redis配置信息
    public void testGetRedisConfig(){
        System.out.println(redisConfig.getHost());
        System.out.println(redisConfig.getPort());
        System.out.println(redisConfig.getPassword());
        System.out.println(redisConfig.getDatabase());
    }
}
