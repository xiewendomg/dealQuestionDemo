package com.xiewendomg.admin.bigdata.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZookeeperClient implements Watcher {

    private static String host = "192.168.1.11:2181";
    private static ZooKeeper zoo = null;

    //创建连接
    public void createZooKeeperClient() {
        try {
            zoo = new ZooKeeper(host, 3, this::process);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建临时节点
    public void  createNode(){
//        zoo.create();
    }
    public static void main(String[] args) throws IOException {
        ZooKeeper zoo = new ZooKeeper(host, 3, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功！");
            }
        });


        System.out.println("==========");


    }


    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("连接成功");
    }
}
