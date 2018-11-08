package com.xiewendomg.admin.java.RPC;

public class HelloWorldServiceImpl implements HelloWorldService{
    public String sayHello(String msg) {
        String result = "hello world , "+msg;
        System.out.println(result);
        return result;
    }
}
