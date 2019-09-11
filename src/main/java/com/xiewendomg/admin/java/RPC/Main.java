package com.xiewendomg.admin.java.RPC;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;









public class Main {
    public static void main(String[] args) {

       /* IVehical car = new Car();
        VehicalProxy proxy = new VehicalProxy();

        IVehical proxyObj = (IVehical)proxy.create(IVehical.class,car);
        proxyObj.run();*/

        HelloService HelloService1=new HelloServiceImpl();
        ProxyUser proxyUser =new ProxyUser();
        HelloService o = (HelloService) proxyUser.getProxy(HelloService.class,HelloService1);
        o.sayHello("rec");



       HelloService HelloService=new HelloServiceImpl();
        VehicalProxy proxy = new VehicalProxy();
        HelloService proxyObj = (HelloService)proxy.create(HelloService.class,HelloService);
        proxyObj.sayHello("rec");



    }
}
