package com.lr.blog;

import com.lr.concurrent.reentrantReadWriteLock.MyReadWriteLock;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author liurui
 * @date 2020/2/4 16:03
 */
public class MyCallAble implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallAble callAble = new MyCallAble();

        FutureTask<Integer> task = new FutureTask(callAble);

        new Thread(task).start();
        int index = task.get();

        System.out.println(index);

    }
}
