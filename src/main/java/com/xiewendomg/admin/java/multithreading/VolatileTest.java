package com.xiewendomg.admin.java.multithreading;

import java.util.concurrent.CountDownLatch;

public class VolatileTest {
    public static volatile int inc = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest volatileTest = new VolatileTest();
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        volatileTest.increase();
                    }
                    countDownLatch.countDown();
                }

                ;
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();

        System.out.println(inc);
    }

}
