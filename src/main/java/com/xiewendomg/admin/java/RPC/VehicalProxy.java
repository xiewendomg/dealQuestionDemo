package com.xiewendomg.admin.java.RPC;

import java.lang.reflect.Proxy;

public class VehicalProxy {
    public Object create(Class cls,Object object1){
        final Class<?>[] interfaces = new Class[]{cls};
        final VehicalInvacationHandler handler = new VehicalInvacationHandler(object1);
        Object object= Proxy.newProxyInstance(cls.getClassLoader(), interfaces, handler);
        return object ;
    }
}
