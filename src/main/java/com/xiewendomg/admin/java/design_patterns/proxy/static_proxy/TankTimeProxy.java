package com.xiewendomg.admin.java.design_patterns.proxy.static_proxy;

public class TankTimeProxy implements Moveable {
    Moveable t;

    public TankTimeProxy(Moveable t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("Start time ............."+System.currentTimeMillis());
        t.run();
        System.out.println("End time ................"+System.currentTimeMillis());
    }
}
