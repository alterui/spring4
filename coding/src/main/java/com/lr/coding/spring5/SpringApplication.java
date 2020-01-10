package com.lr.coding.spring5;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liurui
 * @date 2020/1/10 16:42
 */

public class SpringApplication {
    @Autowired
    private SpringService springService;


    public  int getSpringService() {
        return springService.getNum();
    }



    public static void main(String[] args) {

        //初始化Bean 初始化容器 上下文
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println(applicationContext.getBean("springService"));

        SpringApplication application = new SpringApplication();
        int springService = application.getSpringService();
        System.out.println(springService);



    }
}
