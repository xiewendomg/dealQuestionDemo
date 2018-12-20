package com.xiewendomg.admin.java.design_patterns.proxy.static_proxy;

import com.xiewendomg.admin.java.design_patterns.proxy.static_proxy.Moveable;

public class Tank implements Moveable {
    @Override
    public void run() {
        System.out.println("小坦克再跑");
    }
}
