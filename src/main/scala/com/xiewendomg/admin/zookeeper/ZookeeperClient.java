package com.xiewendomg.admin.zookeeper;

import org.apache.hadoop.util.hash.Hash;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.util.*;

/**
 * zookeeper 单线程分布式实现
 * 多线程分布式实现
 */
public class ZookeeperClient {

    /**
     * 连接zookeeper
     *
     * @throws IOException
     */
    public ZooKeeper initZK() throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("manager:2181,slave1:2181,slave2:2181", 60000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接zookeeper");
            }
        });
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
        getLock(zooKeeper, create);
    }

    public void getLock(ZooKeeper zooKeeper, String create) throws KeeperException, InterruptedException {
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
            System.out.println(beforeNode);
            //一直监听
            Watcher watcher = new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("注册watcher");
                    try {
                        doSomething(create, zooKeeper);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Stat stat = zooKeeper.exists(beforeNode, watcher);
            if (stat != null) {
                try {
                    System.in.read();//让控制台仅需运行 输入从-1到255个字节
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                getLock(zooKeeper, create);
            }

        }
    }

    //获得锁的处理
    public void doSomething(String create, ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println("gain lock: " + create);
        System.out.println("finished: " + create);
        zooKeeper.delete(create, -1);
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 250; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        ZookeeperClient client = new ZookeeperClient();
                        ZooKeeper zooKeeper = client.initZK();
                        client.createNode(zooKeeper);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

//        client.closeZK();
    }

}
