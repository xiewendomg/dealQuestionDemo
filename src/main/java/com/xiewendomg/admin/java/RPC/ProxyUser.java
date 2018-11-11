package com.xiewendomg.admin.java.RPC;

import org.apache.commons.collections.iterators.ObjectGraphIterator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUser {

    public  static Object getProxy(Class cls, Object object){
        RpcClient rpcClient=new RpcClient(object);
        return Proxy.newProxyInstance(cls.getClassLoader(),new Class[]{cls},rpcClient);
    }
}

class RpcClient implements InvocationHandler{

    private Object object;
    public RpcClient(Object object){
        this.object=object;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("befor rpc .....");
        Object obj=method.invoke(object,args);
        System.out.println("after rpc .....");
        return obj;
    }
}