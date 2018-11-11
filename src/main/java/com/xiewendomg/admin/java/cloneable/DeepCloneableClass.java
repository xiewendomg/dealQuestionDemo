package com.xiewendomg.admin.java.cloneable;

public class DeepCloneableClass {

    public CopyTest data1=null;
    private double data2=0;
    public String data3=null;
    public StringBuffer data4=null;

    public DeepCloneableClass(CopyTest data1, double data2, String data3, StringBuffer data4) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }
    public void show(){
        System.out.println(data1.userData);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(data4);
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        CopyTest copyTest=new CopyTest(data1.userData);
        StringBuffer stringBuffer=new StringBuffer(data4.toString());
        return new DeepCloneableClass(copyTest,data2,data3,stringBuffer);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CopyTest shallowCopyTest=new CopyTest("good morning!");
        StringBuffer stringBuffer=new StringBuffer("origin data");
        DeepCloneableClass origin=new DeepCloneableClass(shallowCopyTest,1.0,"origin",stringBuffer);
        DeepCloneableClass copy=null;
        Object object=origin.clone();
        if (object instanceof DeepCloneableClass){
            copy= (DeepCloneableClass) object;
        }
        System.out.println("copy==origin is "+(copy==origin));
        System.out.println("data of origin:");
        origin.show();
        System.out.println("data of copy：");
        copy.show();

        System.out.println("org.data1 == copy.data1? " + (origin.data1 == copy.data1));
        System.out.println("org.data2 == copy.data2? " + (origin.data2 == copy.data2));
        System.out.println("org.data3 == copy.data3? " + (origin.data3 == copy.data3));
        System.out.println("org.data4 == copy.data4? " + (origin.data4 == copy.data4));

        //修改copy中的指向对象的属性
        copy.data1.userData="Copy goood morning!";
        copy.data2=2.0;
        copy.data3="Copy";
        copy.data4.replace(0,copy.data4.length(),"copy data");
        System.out.println("After modify,data of origin:");
        origin.show();
        System.out.println("After modify,data of copy:");
        copy.show();
    }
}
