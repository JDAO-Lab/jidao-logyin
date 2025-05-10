package com.longYin.utils;


import com.longYin.config.RedisConfig;
import com.longYin.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Map;

@Component
public class RedisUtil {

    @Autowired
    private RedisConfig redisConfig;
    private Jedis jedis;

    @Autowired
    //实例化redis工具类
    public RedisUtil(RedisConfig redisConfig) {
        this.redisConfig = redisConfig;
        initializeRedisConnection();
    }

    //初始化redis服务
    private void initializeRedisConnection() {
        try {
            //初始化redis并设置前缀及过期时间
            jedis = new Jedis(redisConfig.getHost(), redisConfig.getPort(), redisConfig.getTimeout());
            String password = redisConfig.getPassword();
            if (password != null && !password.isEmpty()) {
                jedis.auth(password);
            }
            jedis.select(redisConfig.getDatabase());
            System.out.println("Redis is running...");
        } catch (JedisConnectionException e) {
            // 处理连接失败逻辑
            System.out.println("Redis connection error: " + e.getMessage());
        }
    }

    //通用的前缀获取方法
    private String getPrefixedKey(String key) {
        return redisConfig.getKeyPrefix() + "_" + key;
    }

    // 设置对象数据 转为json字符串 有有效期
    public void setValue(String key, Object value, int expireTimeInSeconds) {
        String jsonValue = JsonUtils.objectToJson(value);
        jedis.set(getPrefixedKey(key), jsonValue);
        jedis.expire(getPrefixedKey(key), expireTimeInSeconds);
    }

    //设置对象数据 转为json字符串 无有效期
    public void setValue(String key, Object value) {
        setValue(key, value, 24*3600*365);
    }

    // 设置键值对 字符串存储 有有效期
    public void setValue(String key, String value, int expireTimeInSeconds) {
        jedis.set(getPrefixedKey(key), value);
        jedis.expire(getPrefixedKey(key), expireTimeInSeconds);
    }

    //无有效期设置值
    public void setValue(String key, String value) {
        setValue(key, value, 24*3600*365);
    }

    // 获取指定 key 的值 返回字符串
    public String getValue(String key) {
        return jedis.get(getPrefixedKey(key));
    }

    // 获取指定key 的值 返回对象数据
    public <T> T getObject(String key, Class<T> clazz) {
        String jsonValue = jedis.get(getPrefixedKey(key));
        return JsonUtils.jsonToObject(jsonValue,clazz);
    }

    // 获取指定key 的值 返回map对象
    public Map<String, Object> getMap(String key) {
        String jsonValue = jedis.get(getPrefixedKey(key));
        return JsonUtils.jsonToMap(jsonValue);
    }

    // 判断 key 是否存在
    public boolean isHashKey(String key) {
        return jedis.exists(getPrefixedKey(key));
    }

    // 删除指定 key
    public void deleteKey(String key) {
        if (jedis.exists(getPrefixedKey(key))) {
            // 删除 key
            Long deletedKeys = jedis.del(getPrefixedKey(key));
            PrintUtils.print("成功删除了 " + deletedKeys + " 个key");
        } else {
            PrintUtils.print("key 不存在");
        }
    }
}