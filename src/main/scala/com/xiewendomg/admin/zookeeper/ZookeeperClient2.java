package com.xiewendomg.admin.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * zookeeper 单线程分布式实现
 */
public class ZookeeperClient2 {

    /**
     * 连接zookeeper
     *
     * @throws IOException
     */
    public ZooKeeper initZK() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("manager:2181,slave1:2181,slave2:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接zookeeper");
                System.out.println(watchedEvent.getType() + "+++++" + watchedEvent.getPath());
            }
        });
        Thread.sleep(1000);
        return zooKeeper;
    }

    /**
     * 关闭zookeeper连接
     *
     * @throws InterruptedException
     */
    public void closeZK(ZooKeeper zooKeeper) throws InterruptedException {
        if (zooKeeper != null) {
            zooKeeper.close();
        }
    }


    /**
     * 常见临时序列节点  ACL是权限
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void createNode(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        String create = zooKeeper.create("/lock/lock", "lock".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        //不监听 false
        List<String> list = zooKeeper.getChildren("/lock", false);
        String thisNode = create.substring(6);
        Collections.sort(list);
        int index = list.indexOf(thisNode);
        if (index == -1) {
            //不存在不处理事件
        } else if (index == 0) {
            doSomething(create, zooKeeper);
        } else {
            //在thisNode前一个添加监听
            String beforeNode = "/lock/" + list.get(index - 1);
            //一直监听
            zooKeeper.getData(beforeNode, true, new Stat());
        }
    }

    //获得锁的处理
    public void doSomething(String create, ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println("gain lock: " + create);
        Thread.sleep(1000);
        System.out.println("finished: " + create);
        zooKeeper.delete(create, -1);
    }

    public static void main(String[] args) throws Exception {
        ZookeeperClient2 client = new ZookeeperClient2();
        ZooKeeper zooKeeper = client.initZK();
        client.createNode(zooKeeper);

//        client.closeZK();
    }

}
