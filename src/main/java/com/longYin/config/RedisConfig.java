// RedisConfig.java
package com.longYin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private Integer port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.key-prefix}")
    private String keyPrefix;

    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public Integer getDatabase() {
        return database;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }
}