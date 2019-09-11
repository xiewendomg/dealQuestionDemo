package com.xiewendomg.admin.java.multithreading;

public  class   SynchronizedTest {
    private static Integer num;
    private static String a="sdfs";
    public  synchronized void method01(String arg) {

        try {
            if("a".equals(arg)){
                num = 100;
                a="sdfs"+"tag a set number over";
                System.out.println(a);
                Thread.sleep(1000);
            }else{
                num = 200;
                a="sdfs"+"tag b set number over";
                System.out.println(a);
            }

                System.out.println("tag = "+ arg + ";num ="+ num);
                System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final SynchronizedTest m1 = new SynchronizedTest();
        final SynchronizedTest m2 = new SynchronizedTest();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                m1.method01("a");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                m1.method01("b");
            }
        });
        t2.start();

    }
}
