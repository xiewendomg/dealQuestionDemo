package com.xiewendomg.admin.bigdata;

public class User {
    private int age;
    private String name;
    private int userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User(int age, String name, int userId) {
        this.name = name;
        this.age = age;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", userId=" + userId +
                '}';
    }
}
