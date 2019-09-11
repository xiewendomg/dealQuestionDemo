package com.xiewendomg.admin.java;

import javafx.scene.control.ProgressBar;
import org.datanucleus.plugin.Bundle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试hashMap 扩容机制
 */
public class HashMapTest extends Thread{

    public static void main(String[] args) throws Throwable {
        testHashMap();
        new HashMapTest().finalize();
    }


    /**
     * 测试
     */
    private static  void  testHashMap() throws InterruptedException {
        Map map=new HashMap(4);
        Thread thread=new HashMapTest();
        Thread thread2= new HashMapTest();
        thread.start();thread2.start();
        while (thread.isAlive()||thread2.isAlive()){
            System.out.println("sdfsd");
        }
        
    }

    /**
     *   |= 位运算 或运算符
     */
    private static  void  math(){
        int n = 12 - 1;
        System.out.println(n);
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n &= n >>> 1);
        System.out.println(n |= n >>> 2);
        System.out.println(n |= n >>> 4);
        System.out.println(n |= n >>> 8);
        System.out.println(n |= n >>> 16);
        System.out.println(n>>> 2);
        System.out.println(n>>> 4);
        System.out.println(n>>> 8);
        System.out.println(n>>> 16);

        System.out.println( -8 >> 1);
        System.out.println( -8 >>> 1);
    }

    @Override
    public void run() {
        System.out.println("start");
    }
    ExecutorService mCachedThreadPool = Executors.newCachedThreadPool();

}
