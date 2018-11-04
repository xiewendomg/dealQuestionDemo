package com.xiewendomg.admin.dataStructure.data;

/**
 * Created by Administrator on 2018/6/24.
 */
public class DnjavaDijstra {
    Graph graph;

    /**
     * 创建图的过程
     */
    public Graph createGraph() {
        Graph graph = new Graph(9);
        int[] a1 = new int[]{0, 1, 5, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX};
        int[] a2 = new int[]{1, 0, 3, 7, 5, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX};
        int[] a3 = new int[]{5, 3, 0, Graph.MAX, 1, 7, Graph.MAX, Graph.MAX, Graph.MAX};
        int[] a4 = new int[]{Graph.MAX, 7, Graph.MAX, 0, 2, Graph.MAX, 3, Graph.MAX, Graph.MAX};
        int[] a5 = new int[]{Graph.MAX, 5, 1, 2, 0, 3, 6, 9, Graph.MAX};
        int[] a6 = new int[]{Graph.MAX, Graph.MAX, 7, Graph.MAX, 3, 0, Graph.MAX, 5, Graph.MAX};
        int[] a7 = new int[]{Graph.MAX, Graph.MAX, Graph.MAX, 3, 6, Graph.MAX, 0, 2, 7};
        int[] a8 = new int[]{Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, 9, 5, 2, 0, 4};
        int[] a9 = new int[]{Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, 7, 4, 0};

        graph.m[0] = a1;
        graph.m[1] = a2;
        graph.m[2] = a3;
        graph.m[3] = a4;
        graph.m[4] = a5;
        graph.m[5] = a6;
        graph.m[6] = a7;
        graph.m[7] = a8;
        graph.m[8] = a9;
        return graph;
    }

    public void shortestPathDijstra() {
        int k = 0;
        for (int i = 0; i < graph.num; i++) {
            graph.isVisited=new boolean[graph.num];
            int w = shortestPathDijstra(i);
            if (k == 0) {
                k = w;
            } else {
                k = k > w ? w : k;
            }
        }
        System.out.println("最短路径为=" + k);
    }

    private int shortestPathDijstra(int j) {
        int[] lowcost = new int[graph.num];
        int[] adjvex = new int[graph.num];// 放顶点权值
        int sum = 0;
        for (int i = 0; i < graph.num; i++) {
            lowcost[i] = graph.m[j][i];
            adjvex[i]=j;
        }
        graph.isVisited[j]=true;
        while (find(lowcost)) {
            int min = Graph.MAX, minId = 0;
            for (int i = 0; i < lowcost.length; i++) {
                if (lowcost[i]>0&&lowcost[i]< Graph.MAX&&min>lowcost[i]) {
                    min = lowcost[i];
                    minId = i;
                }
            }
            lowcost[minId]=0;
            System.out.println("顶点"+adjvex[minId]+"的最小值="+min);
            sum += min;
            int[] next=new int[graph.num];
            for (int i=0;i<graph.num;i++){
                next[i]=graph.m[minId][i];
            }
            for (int i = 0; i < lowcost.length; i++) {
                if (lowcost[i] > 0) {
                    if (lowcost[i] >next[i]) {
                        lowcost[i] = next[i];
                        adjvex[i]=minId;
                    }
                }

            }

        }

        return sum;
    }

    private boolean find(int[] lowcost) {
        for (int i:lowcost){
            if (i!=0){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DnjavaDijstra dnjavaDijstra = new DnjavaDijstra();
        dnjavaDijstra.graph = dnjavaDijstra.createGraph();
        dnjavaDijstra.shortestPathDijstra();
    }
}
