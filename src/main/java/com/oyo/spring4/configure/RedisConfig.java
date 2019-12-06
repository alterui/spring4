package com.oyo.spring4.configure;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liurui
 * @date 2019/12/6 16:29
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redissonClient(){
        return  Redisson.create();
    }

}
