package com.lr.annotation.application;

import com.lr.annotation.bean.City;
import com.lr.annotation.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liurui
 * @date 2020/3/20 10:12
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        City city = annotationConfigApplicationContext.getBean(City.class);
        System.out.println(city);

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanNamesForType(City.class);
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
