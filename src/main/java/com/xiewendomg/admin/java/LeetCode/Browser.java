package com.xiewendomg.admin.java.LeetCode;

import java.util.Stack;

public class Browser {
    private static Stack<String> browser1 = new Stack();
    private static Stack<String> browser2 = new Stack();

    public static void main(String[] args) {
        browser1.push("A");
        browser1.push("B");
        browser1.push("C");
        pop();
        pop();
        pushA("D");
        pop();
        pop();
        pushB();
        pushB();
    }


    //新的前进
    private static void pushA(String string) {
        System.out.println(string);
        browser1.push(string);
        browser2.clear();
    }

    //旧的前进
    private static void pushB() {
        String pop = browser2.pop();
        System.out.println(pop);
        browser1.push(pop);
    }

    //后退
    private static void pop() {
        String pop = browser1.pop();
        System.out.println(pop);
        browser2.push(pop);
    }
}
