package com.lr.concurrent.reentrantlock;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author liurui
 * @date 2020/1/12 9:42
 */
public class MyAQSLock implements Lock {

    private Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer{
        /**
         * Acquire方法也是调用该方法，所以只有直线tryAcquire方法即可。
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
           //第一个线程进来，返回true；第二个线程进来，返回false；

            /*
              getState()默认为0；
             */
            int state = getState();
            if (state == 0) {
                //compare and set value
                if (compareAndSetState(0, arg)) {
                    //把当前线程设置
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
        }

        /**
         * 试图释放锁，释放成功则返回true
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            //释放锁和加锁肯定是一一对应的
            if (getExclusiveOwnerThread() != Thread.currentThread()) {
                throw  new RuntimeException("lock is not exist");
            }

            boolean flag = false;

            int state = getState() - arg;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                flag = true;
            }

            setState(state);
            return flag;
        }

        protected Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }



}
