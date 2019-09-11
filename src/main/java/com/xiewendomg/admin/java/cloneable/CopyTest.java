package com.xiewendomg.admin.java.cloneable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 浅拷贝实体类
 */
public class CopyTest {
    {
        System.out.println("代码块");
    }
    static {
        System.out.println("静态代码块");
    }
    public  String userData;
    public CopyTest(String userData){
        System.out.println("构造代码块");
        this.userData=userData;
    }

    public static void main(String[] args) {
        new CopyTest("df");
    }
    @Override
    public String toString() {
        return "CopyTest{" +
                "userData='" + userData + '\'' +
                '}';
    }

}
