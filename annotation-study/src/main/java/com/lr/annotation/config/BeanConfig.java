package com.lr.annotation.config;

import com.lr.annotation.bean.City;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liurui
 * @date 2020/3/20 10:55
 */
@Configuration
public class BeanConfig {

    @Bean("city")
    public City city() {
        return new City(001,"上海");
    }


}
