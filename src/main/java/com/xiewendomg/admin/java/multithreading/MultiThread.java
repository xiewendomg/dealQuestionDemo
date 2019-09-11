package com.xiewendomg.admin.java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MultiThread {
    public static void main(String[] args) {
       ExecutorService es= Executors.newCachedThreadPool();
       final Semaphore semaphore=new Semaphore(14);
       for (int i=0;i<14;i++){

           Thread thread=new Thread(){
               @Override
               public void run() {
                   try {
                       semaphore.acquire(7);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   try {
                       Thread.sleep(10000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println(getName());
                   semaphore.release(7);
               }
           };

           es.execute(thread);
       }
        try {
            semaphore.acquire(14);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("东东");

    }
}
