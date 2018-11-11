package com.xiewendomg.admin.java.RPC;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VehicalInvacationHandler  implements InvocationHandler {
    private final Object vehical;

    public VehicalInvacationHandler(Object vehical) {
        this.vehical = vehical;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        System.out.println("--before running...");
        Object ret = method.invoke(vehical, args);
        System.out.println("--after running...");

        return ret;
    }

}
