package com.lr.api.applicaiton;

import com.lr.api.annotation.Student;
import com.lr.api.configation.StudentBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author liurui
 * @date 2020/3/18 13:54
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentBean.class);

        Student bean = applicationContext.getBean(Student.class);
        System.out.println(bean);


    }
}
