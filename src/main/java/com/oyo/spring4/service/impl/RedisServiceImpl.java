package com.oyo.spring4.service.impl;

import com.oyo.spring4.service.RedisService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liurui
 * @date 2019/12/6 17:40
 */

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedissonClient redissonClient;



    @Override
    public void update() {
        RLock lock = redissonClient.getLock("lock");
        try {
            if (!lock.tryLock(3,10, TimeUnit.SECONDS)){
                System.out.println("！！！！有人在操作，请勿进行其他操作");
            }
        } catch (InterruptedException e) {
           // e.printStackTrace();
        }finally {
            if (lock.isLocked()) {
                //释放锁
                lock.unlock();
            }
        }
    }

    @Override
    public void delete() {
        RLock lock = redissonClient.getLock("lock");
        try {

            if (!lock.tryLock(3, 10, TimeUnit.SECONDS)){
                System.out.println("！！！！有人在操作，请勿进行其他操作");
            }

        } catch (InterruptedException e) {
           // e.printStackTrace();
        }finally {
            if (lock.isLocked()) {
                //释放锁
                lock.unlock();
            }
        }
    }
}
