package com.xiewendomg.admin.java.LeetCode;

public class DaGuan {
    public static void main(String[] args) {
        Node node1=new Node();
        Node node2=new Node(node1);
        Node node3=new Node(node2);
        Node node4=new Node(node3);
        Node node5=new Node(node4);
        Node node6=new Node(node3);
        node1.setNext(node6);

        System.out.println(hasLoop(node5));
    }

    /**
     * 判断列表是否有环
     * @param node
     * @return
     */
    public static int hasLoop(Node node) {
        if (node == null) {
            return 2;
        }
        Node tmp1 = node;
        Node tmp2 = node.getNext();
        while (tmp2 != null) {
            if (tmp1 == tmp2) {
                return 1;
            }
            tmp1 = tmp1.getNext();
            if (tmp2.getNext() == null || tmp2.getNext().getNext() == null) {
                return 0;
            }
            tmp2 = tmp2.getNext().getNext();
        }
        return 0;
    }



}
