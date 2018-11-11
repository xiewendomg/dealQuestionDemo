package com.xiewendomg.admin.java.serializable;

import java.io.*;

/**
 * 测试序列化实体类
 */
public class Person {
    //一会就说这个是做什么的
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "name:"+name+"\tage:"+age;
    }

    public static void main   (String[] args) throws  Exception{
        File file = new File("d:/"+File.separator+"out.txt");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(fos);
                Person person = new Person("tom", 22);
                // 调用 person的 tostring() 方法
                System.out.println(person);
                //写入对象
                oos.writeObject(person);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("oos关闭失败："+e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件："+e.getMessage());
        } finally{
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("fos关闭失败："+e.getMessage());
            }
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(fis);
                try {
                    Person person = (Person)ois.readObject();   //读出对象
                    System.out.println(person);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("ois关闭失败："+e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到文件："+e.getMessage());
        } finally{
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("fis关闭失败："+e.getMessage());
            }
        }
    }
}
