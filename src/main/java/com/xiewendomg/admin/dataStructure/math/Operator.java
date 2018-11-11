package com.xiewendomg.admin.dataStructure.math;

/**
 * java 运算符
 */
public class Operator {
    public static void main(String[] args) {
        result();
    }

    /**
     * >> 除以 / ,<<,>>>
     */
    private static void result(){
        int a=5;
        System.out.println("a>>1="+String.valueOf(a>>1));
        System.out.println("a<<1="+String.valueOf(a<<1));
        System.out.println("a>>>1="+String.valueOf(a>>>1));
    }
}
