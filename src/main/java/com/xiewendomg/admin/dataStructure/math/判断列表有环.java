package com.xiewendomg.admin.dataStructure.math;

public class 判断列表有环 {
    public static void main(String[] args) {
        判断列表有环 s = new 判断列表有环();
        System.out.println(s.isExistHoop(s.createRoot()));
        System.out.println(s.getEntrance(s.createRoot()).getName());
    }

    //用快、慢指针判断列表是否有环
    public boolean isExistHoop(A root) {
        if (root == null || root.next == null) {
            return false;
        }
        A next = root, nextnext = root;
        while (true) {
            next = next.next;
            nextnext = nextnext.next.next;
            if (next == nextnext) {
                return true;
            }
        }
    }

    //找出环的入口
    public A getEntrance(A root) {
        if (root == null || root.next == null) {
            return null;
        }
        A next = root, nextnext = root;
        while (true) {
            next = next.next;
            nextnext = nextnext.next.next;
            if (next == nextnext) {
                next=root;
                while (true){
                    next = next.next;
                    nextnext = nextnext.next;
                    if (next==nextnext){
                        return next;
                    }
                }
            }
        }
    }

    //创建一个有环的列表
    public A createRoot() {
        A a = new A();
        A a1 = new A("a1", a);
        A a2 = new A("a2", a1);
        A a3 = new A("a3", a2);
        A a4 = new A("a4", a3);
        A a5 = new A("a5", a4);
        A a6 = new A("a6", a5);
        A a7 = new A("a7", a6);
        A a8 = new A("a8", a7);
        A a9 = new A("a9", a8);
        A a10 = new A("a10", a9);
        a.setNext(a1);

        a.setName("a");

        return a10;
    }

    class A {
        private String name;
        private A next;

        public A() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public A(String name, A next) {
            this.name = name;
            this.next = next;
        }

        public A(A next) {
            this.next = next;
        }


        public A getNext() {
            return next;
        }

        public void setNext(A next) {
            this.next = next;
        }
    }

}