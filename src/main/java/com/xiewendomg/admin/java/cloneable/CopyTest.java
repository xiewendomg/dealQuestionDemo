package com.xiewendomg.admin.java.cloneable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 浅拷贝实体类
 */
public class CopyTest {
    public  String userData;
    public CopyTest(String userData){
        this.userData=userData;
    }

    @Override
    public String toString() {
        return "CopyTest{" +
                "userData='" + userData + '\'' +
                '}';
    }

}
