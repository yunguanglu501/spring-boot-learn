package com.example.learn.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: wcy
 * @CreateDate: 2022/6/10 15:06
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient getRedisson(){
        Config config=new Config();
        config.useSingleServer().setAddress("redis://192.168.180.140:6379");
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

}
