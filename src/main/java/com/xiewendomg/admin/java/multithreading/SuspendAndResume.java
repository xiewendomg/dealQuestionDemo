package com.xiewendomg.admin.java.multithreading;

public class SuspendAndResume {
    public static void main(String[] args) {
        System.out.println("start================");
        Thread thread= new Thread(){
            @Override
            public void run() {
                System.out.println("Thread start================");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread end================");
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.suspend();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("suport================");
        thread.resume();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end================");

    }


}
class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread======start=======");
        System.out.println("MyThread======eMyThreadnd=======");
    }
}