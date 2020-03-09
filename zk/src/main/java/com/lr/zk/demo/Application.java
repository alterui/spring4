package com.lr.zk.demo;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author liurui
 * @date 2020/3/3 10:18
 */
public class Application {
    private String connectString = "192.168.43.128:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper client;
    @Before
    public void init() throws IOException {
       client  = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    @Test
    public void create() throws KeeperException, InterruptedException {
        String s = client.create("/ww",
                "jinlian".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(s);
        String a = "1";
    }

    
}
