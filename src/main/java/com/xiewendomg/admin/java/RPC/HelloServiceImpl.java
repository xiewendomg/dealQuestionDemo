package com.xiewendomg.admin.java.RPC;

public class HelloServiceImpl implements HelloService{
    public void sayHello(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        String str1 = "myString";

        String str2 = "myString";

        System.out.println(str1 ==str2 );
    }
}
