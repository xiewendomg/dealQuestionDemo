package com.xiewendomg.admin.dataStructure.data;

import java.util.Arrays;

/**
 * 最小生成树 普里姆算法 克鲁斯卡尔算法
 */
public class MinTree {
    Graph graph;

    /**
     * 普里姆算法
     */
    public void prim(){

    }
    public void prim(int f){
        int[] lowcost=new int[graph.num];//最小代價頂點權值的數組，為0表示已經找到最小權值
        int[] adjvex=new int[graph.num];//頂點的數組
        int min,minId,sum=0;
        for (int i=0;i<graph.num;i++){
            lowcost[i] = graph.m[0][i];
        }
        for (int i=1;i<graph.num;i++){
            min= Graph.MAX;
            minId=0;
            for (int j=1;j<graph.num;j++){
                if (lowcost[j]<min&&lowcost[j]>0){
                    min=lowcost[j];
                    minId=j;
                }
            }
            System.out.println("頂點"+adjvex[minId]+"最小權值"+min);
            sum+=min;
            lowcost[minId]=0;
            for (int j=1;j<graph.num;j++){
                if (lowcost[j]!=0&&graph.m[minId][j]<lowcost[j]){
                    lowcost[j]=graph.m[minId][j];
                    adjvex[j]=minId;
                }
            }
            System.out.println(Arrays.toString(lowcost));
        }
        System.out.println("最小生成樹權值="+sum);
    }
    public static void main(String[] args) {
        MinTree minTree=new MinTree();
        Graph graph = new Graph(9);

        int [] a1 = new int[]{0,10, Graph.MAX, Graph.MAX, Graph.MAX,11, Graph.MAX, Graph.MAX, Graph.MAX};
        int [] a2 = new int[]{10,0,18, Graph.MAX, Graph.MAX, Graph.MAX,16, Graph.MAX,12};
        int [] a3 = new int[]{Graph.MAX, Graph.MAX,0,22, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX,8};
        int [] a4 = new int[]{Graph.MAX, Graph.MAX,22,0,20, Graph.MAX, Graph.MAX,16,21};
        int [] a5 = new int[]{Graph.MAX, Graph.MAX, Graph.MAX,20,0,26, Graph.MAX,7, Graph.MAX};
        int [] a6 = new int[]{11, Graph.MAX, Graph.MAX, Graph.MAX,26,0,17, Graph.MAX, Graph.MAX};
        int [] a7 = new int[]{Graph.MAX,16, Graph.MAX, Graph.MAX, Graph.MAX,17,0,19, Graph.MAX};
        int [] a8 = new int[]{Graph.MAX, Graph.MAX, Graph.MAX,16,7, Graph.MAX,19,0, Graph.MAX};
        int [] a9 = new int[]{Graph.MAX,12,8,21, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX,0};

        graph.m[0] = a1;
        graph.m[1] = a2;
        graph.m[2] = a3;
        graph.m[3] = a4;
        graph.m[4] = a5;
        graph.m[5] = a6;
        graph.m[6] = a7;
        graph.m[7] = a8;
        graph.m[8] = a9;

        minTree.graph=graph;
        minTree.prim();
    }
}
