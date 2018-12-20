package com.xiewendomg.admin.java.design_patterns.proxy.static_proxy;

/**
 * 静态代理测试类
 */
public class Client {
    public static void main(String[] args) {
        Tank tank=new Tank();
        TankLogProxy tankLogProxy=new TankLogProxy(tank);
        TankTimeProxy tankTimeProxy=new TankTimeProxy(tankLogProxy);
        Moveable moveable=tankTimeProxy;
        moveable.run();
    }
}
