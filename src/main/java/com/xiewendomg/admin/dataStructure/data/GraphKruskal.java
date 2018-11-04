package com.xiewendomg.admin.dataStructure.data;

/**
 * 克鲁斯图
 */
public class GraphKruskal {
    private Edge[] edges;
    private int edgeSize;
    public GraphKruskal(int edgeSize){
        this.edgeSize=edgeSize;
        edges=new Edge[edgeSize];
    }
    public void createEdgeArray(){
        Edge edge0 = new Edge(4,7,7);
        Edge edge1 = new Edge(2,8,8);
        Edge edge2 = new Edge(0,1,10);
        Edge edge3 = new Edge(0,5,11);
        Edge edge4 = new Edge(1,8,12);
        Edge edge5 = new Edge(3,7,16);
        Edge edge6 = new Edge(1,6,16);
        Edge edge7 = new Edge(5,6,17);
        Edge edge8 = new Edge(1,2,18);
        Edge edge9 = new Edge(6,7,19);
        Edge edge10 = new Edge(3,4,20);
        Edge edge11 = new Edge(3,8,21);
        Edge edge12 = new Edge(2,3,22);
        Edge edge13 = new Edge(3,6,24);
        Edge edge14 = new Edge(4,5,26);
        edges[0] = edge0;
        edges[1] = edge1;
        edges[2] = edge2;
        edges[3] = edge3;
        edges[4] = edge4;
        edges[5] = edge5;
        edges[6] = edge6;
        edges[7] = edge7;
        edges[8] = edge8;
        edges[9] = edge9;
        edges[10] = edge10;
        edges[11] = edge11;
        edges[12] = edge12;
        edges[13] = edge13;
        edges[14] = edge14;
    }
    class Edge{
        private int begin;
        private int end;
        private int weight;

        public Edge(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
    public void  spanMinTree(){
        int k=0,w;
        for (int i=0;i<edgeSize;i++){
            w= spanMinTree(i);
            if (k==0){
                k=w;
            }else {
               k= k<w?k:w;
            }
        }
        System.out.println(k);

    }
    public int  spanMinTree(int f){
        int[] parent =new int[edgeSize];//下标为起点，值为终点
        int sum=0;
        for (int i=f;i<edgeSize;i++){
            int n=find(parent,edges[i].begin);
            int m=find(parent,edges[i].end);
            if (n!=m){
                parent[n]=m;
                sum+=edges[i].weight;
                System.out.println("起点为="+edges[i].begin+"终点为="+edges[i].end+"权值为="+edges[i].weight);
            }
        }
        for (int i=0;i<f;i++){
            int n=find(parent,edges[i].begin);
            int m=find(parent,edges[i].end);
            if (n!=m){
                parent[n]=m;
                sum+=edges[i].weight;
                System.out.println("起点为="+edges[i].begin+"终点为="+edges[i].end+"权值为="+edges[i].weight);
            }
        }
        System.out.println("最小权值="+sum);
        return sum;
    }

    private int find(int[] parent, int f) {
        while (parent[f]>0){
            f=parent[f];
        }
        return f;
    }

    public static void main(String[] args) {
        GraphKruskal graphKruskal=new GraphKruskal(15);
        graphKruskal.createEdgeArray();
        graphKruskal.spanMinTree();
    }
}
