package com.xiewendomg.admin.dataStructure.data;

/**
 * 图
 */
public class Graph {
    //顶点数量
    public int num;
    //顶点数组
    public int[] v;
    //图
    public int[][] m;
    //顶点间不连通
    public static int MAX = 100;

    public boolean[] isVisited;

    public Graph(int n) {
        this.num = n;
        this.v = new int[n];
        this.m = new int[n][n];
        this.isVisited=new boolean[n];
    }

    /**
     * 根据顶点查找顶点的出度
     *
     * @param index 顶点
     * @return
     */
    public int getOutDegree(int index) {
        int degree = 0;
        for (int i = 0; i < num; i++) {
            if (m[index][i] != 0 && m[index][i] != MAX) {
                degree++;
            }
        }
        return degree;
    }
    /**
     * 根据顶点查找顶点的入度
     *
     * @param index 顶点
     * @return
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int i = 0; i < num; i++) {
            if (m[i][index] != 0 && m[i][index] != MAX) {
                degree++;
            }
        }
        return degree;
    }
    /**
     * 根据查找两个顶点v1到v2的出度的权值
     *
     * @return
     */
    public int getWeight(int v1,int v2) {
        int weight = m[v1][v2];
        return weight==0?0:(weight==MAX?-1:weight);
    }

    public static void main(String[] args) {
        Graph app = new Graph(5);
        int[] a0 = new int[]{0, MAX, MAX, MAX, 6};
        int[] a1 = new int[]{9, 0, 3, MAX, MAX};
        int[] a2 = new int[]{2, MAX, 0, 5, MAX};
        int[] a3 = new int[]{MAX, MAX, MAX, 0, 1};
        int[] a4 = new int[]{MAX, MAX, MAX, MAX, 0};
        app.m[0] = a0;
        app.m[1] = a1;
        app.m[2] = a2;
        app.m[3] = a3;
        app.m[4] = a4;


        System.out.println("出度="+app.getOutDegree(2));
        System.out.println("入度="+app.getInDegree(2));
        System.out.println("权值="+app.getWeight(1,2));
    }
    
    
}
