package com.xiewendomg.admin.java;

public class QuoteTest {

    public static void main(String[] args) {
        quoteMax();
    }

    /**
     * 强应用demo
     */
    private static void quoteMax(){
        student S=new student("1","我是大s");
        student s=S;
        System.out.println(s==S); //true
        System.out.println(s.equals(S)); //true
        System.out.println("打印出大S"+S); //id=1
        System.out.println("打印出小s"+s); //id=1
        S.setId("2");
        System.out.println("修改后的大S"+S);  //id=2
        System.out.println("未修改后的小s"+s); //id=2
        s.setId("3");
        System.out.println("未修改后的大S"+S); //id=3
        System.out.println("修改后的小s"+s); //id=3

        byte[]  bytes=new byte[200];
        byte[]  bytes1=new byte[200];
        byte[]  bytes2=new byte[200];
    }
}
class student{
    String name;
    String id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public student(String name, String id) {
        super();
        this.name = name;
        this.id = id;
    }
    @Override
    public String toString() {
        return "student [name=" + name + ", id=" + id + "]";
    }


}
