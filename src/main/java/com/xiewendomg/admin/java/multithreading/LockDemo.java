package com.xiewendomg.admin.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReebtrantLock 可重入锁demo
 * 同一个类 lock 上锁了，其他地方就不会获得锁
 */
public class LockDemo {

    private Lock lock=new ReentrantLock();
    private Lock lock2=new ReentrantLock();
    private void workOn(){
        System.out.println(Thread.currentThread().getName()+":上班!");
    }
    private void workOff(){
        System.out.println(Thread.currentThread().getName()+"：下班");
    }
    private void work(){
        lock.lock();
        workOn();
        System.out.println(Thread.currentThread().getName()
                + "工作中!!!!");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workOff();
        lock.unlock();
    }
    private void work2(){
        lock2.lock();
        System.out.println("================");
        workOn();
        System.out.println(Thread.currentThread().getName()
                + "工作中!!!!");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workOff();
        lock2.unlock();
    }

    public static void main(String[] args) {
        LockDemo lockDemo=new LockDemo();
        int i=0;
        List<Thread> list=new ArrayList<>(30);
        do {
            Thread a=new Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.work();
                }
            },"小A_"+i);
            Thread b=new Thread(new Runnable() {
                @Override
                public void run() {
                    lockDemo.work2();
                }
            },"小B_"+i);

            list.add(a);
            list.add(b);

        }while (i++<10);

        list.parallelStream().forEach(Thread::start);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over!");
    }
}
