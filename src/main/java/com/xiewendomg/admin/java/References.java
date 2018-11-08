package com.xiewendomg.admin.java;

import java.lang.ref.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 软引用、弱引用和虚引用
 */
 class Grocery {
    private static final int SIZE = 10000;
    // 属性d使得每个Grocery对象占用较多内存，有80K左右
    private double[] d = new double[SIZE];
    private String id;
    public Grocery(String id) {
        this.id = id;
    }
    public String toString() {
        return id;
    }
    public void finalize() {
        System.out.println("即将回收 " + id);
    }
}
public class References {
    private static ReferenceQueue<Grocery> rq = new ReferenceQueue<Grocery>();
    public static void checkQueue() {
        Reference<? extends Grocery> inq = rq.poll(); // 从队列中取出一个引用
        if (inq != null)
            System.out.println("In queue: " + inq + " : " + inq.get());
    }
    public static void main(String[] args) {
        final int size = 10;
        Set<Grocery> sg=new HashSet<Grocery>();
        for (int i = 0; i < size; i++) {
            Grocery ref = new Grocery(
                    "强引用 " + i);
            System.out.println("刚刚 创建了: " + ref);
            ref=null;
            sg.add(ref);
        }

        // 创建10个Grocery对象以及10个软引用
        Set<SoftReference<Grocery>> sa = new HashSet<SoftReference<Grocery>>();
        for (int i = 0; i < size; i++) {
            SoftReference<Grocery> ref = new SoftReference<Grocery>(
                    new Grocery("软引用 " + i), rq);
            System.out.println("刚刚 创建了: " + ref.get());
            ref=null;
            sa.add(ref);
        }
        System.gc();
        checkQueue();
        // 创建10个Grocery对象以及10个弱引用
        Set<WeakReference<Grocery>> wa = new HashSet<WeakReference<Grocery>>();
        for (int i = 0; i < size; i++) {
            WeakReference<Grocery> ref = new WeakReference<Grocery>(
                    new Grocery("弱引用 " + i), rq);
            System.out.println("刚刚 创建了: " + ref.get());

            wa.add(ref);
        }
        System.gc();
        checkQueue();
        // 创建10个Grocery对象以及10个虚引用
        Set<PhantomReference<Grocery>> pa = new HashSet<PhantomReference<Grocery>>();
        for (int i = 0; i < size; i++) {
            PhantomReference<Grocery> ref = new PhantomReference<Grocery>(
                    new Grocery("abc " + i), rq);
            System.out.println("刚刚 创建了: " + ref.get());
            pa.add(ref);
        }
        System.gc();
        checkQueue();
    }
}
