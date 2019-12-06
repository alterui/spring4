package com.oyo.spring4.controller;

import com.oyo.spring4.po.Student;
import com.oyo.spring4.service.RedisService;
import com.oyo.spring4.service.impl.MyThread;
import org.redisson.Redisson;
import org.redisson.RedissonTopic;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author liurui
 * @date 2019/12/6 16:01
 */
@RestController
public class RedisController {
    @Resource
    private RedissonClient redissonClient;


    @Resource
    private MyThread myThread;

    @GetMapping("/editStudent")
    public String getAllStudentList() {

        RLock lock = this.redissonClient.getLock("lock");

        try {
            if (!lock.tryLock(2, 10, TimeUnit.SECONDS)){
                System.out.println("！！！！有人在操作，请勿进行其他操作");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isLocked()) {
                //释放锁
                lock.unlock();
            }
        }

        return "succeed";
    }


    @GetMapping("/deleteStudent")
    public String getRedis() {

        RLock lock = this.redissonClient.getLock("lock");

        try {
           if (!lock.tryLock(2, 10, TimeUnit.SECONDS)){
               System.out.println("！！！！有人在操作，请勿进行其他操作");
           }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock.isLocked()) {
                //释放锁
                lock.unlock();
            }
        }

        return "succeed";
    }


    @GetMapping("/getStudent")
    public String getStudent()  {
        for (int i = 0; i < 100; i++) {
            new Thread(myThread).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }

        return "success";
    }







}
