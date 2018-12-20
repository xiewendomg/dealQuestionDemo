package com.xiewendomg.admin.java.design_patterns.proxy.static_proxy;

public class TankLogProxy implements Moveable {
    public TankLogProxy(Tank t) {
        this.t = t;
    }

    Tank t;
    @Override
    public void run() {
        System.out.println("Log Start.........");
        t.run();
        System.out.println("Log End...........");
    }
}
