package com.xiewendomg.admin.dataStructure.data;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/13.
 */
public class DeapGraphArith {
	Graph graph;

	/**
	 * 找到第一个连接点
	 * 
	 * @param v
	 *            顶点
	 * @return
	 */
	public int getFirstNeighbor(int v) {
		for (int j = 0; j < graph.num; j++) {
			if (graph.m[v][j] > 0 && graph.m[v][j] < Graph.MAX) {
				return j;
			}
		}
		return -1;
	}

	/**
	 * 获取顶点v当前连接点的下标v1后面的下一个连接点
	 * 
	 * @param v
	 *            顶点
	 * @return
	 */
	public int getNextNeighbor(int v, int v1) {
		for (int j = v1 + 1; j < graph.num; j++) {
			if (graph.m[v][j] > 0 && graph.m[v][j] < Graph.MAX) {
				return j;
			}
		}
		return -1;
	}

	public void depthFirstSearch(int index) {
		graph.isVisited[index] = true;
		int w = getFirstNeighbor(index);
		while (w != -1) {
			if (!graph.isVisited[w]) {
				System.out.println("访问到了顶点" + w);
				depthFirstSearch(w);
			}
			w = getNextNeighbor(index, w);
		}
	}

	/**
	 * 深度优先算法
	 */
	public void depthFirstSearch() {

		for (int i = 0; i < graph.num; i++) {
			if (!graph.isVisited[i]) {
				depthFirstSearch(i);
			}

		}
	}

	/**
	 * 广度算法
	 */
	public void broadFirstSearch() {
		for (int i = 0; i < graph.num; i++) {
			if (!graph.isVisited[i]) {
				broadFirstSearch(i);
			}
		}
	}

	private void broadFirstSearch(int i) {
		graph.isVisited[i] = true;
		System.out.println("访问顶点：" + i);
		int u, w;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		while (!queue.isEmpty()) {
			u = queue.removeFirst();
			w = getFirstNeighbor(u);
			while (w != -1) {
				if (!graph.isVisited[w]) {
					System.out.println("访问顶点：" + w);
					graph.isVisited[w] = true;
					queue.add(w);
				}
				w = getNextNeighbor(u, w);

			}
		}
	}

	/**
	 * prim 普里姆算法
	 */
	public void prim(){
		int k=0;
		for(int i=0;i<graph.num;i++){
			int w=prim(i);
			if(k==0){
				k=w;
			}else{
				k=k>w?w:k;
			}
		}
		System.out.println("K的值为="+k);
	}
	public int prim(int k) {
		int[] lowcost = new int[graph.num];// 最小代价顶点权值的数组,为0表示已经获取最小权值
		int[] adjvex = new int[graph.num];// 放顶点权值
		int min, minId, sum = 0;
		for (int i = 0; i < graph.num; i++) {
			lowcost[i] = graph.m[k][i];
		}
		for(int i = 0; i < graph.num; i++){
			adjvex[i]=k;
		}
		while(find(lowcost)) {
			min = Graph.MAX;
			minId = 0;
			for (int j = 0; j < graph.num; j++) {
				if (lowcost[j] < min && lowcost[j] > 0) {
					min = lowcost[j];
					minId = j;
				}
			}
//			System.out.println("顶点：" + adjvex[minId] + "权值：" + min);
			sum += min;
			lowcost[minId] = 0;
			for (int j = 0; j < graph.num; j++) {
				if (lowcost[j] != 0 && graph.m[minId][j] < lowcost[j]) {
					lowcost[j] = graph.m[minId][j];
					adjvex[j] = minId;
				}
			}
			System.out.println(Arrays.toString(lowcost));
		}
		System.out.println("最小生成树权值和:" + sum);
		return sum;
	}

	private boolean find(int[] array) {
		for(int i:array){
			if(i!=0){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		DeapGraphArith dgf = new DeapGraphArith();
		Graph graph = new Graph(9);

		int[] a1 = new int[] { 0, 10, Graph.MAX, Graph.MAX, Graph.MAX, 11, Graph.MAX, Graph.MAX, Graph.MAX };
		int[] a2 = new int[] { 10, 0, 18, Graph.MAX, Graph.MAX, Graph.MAX, 16, Graph.MAX, 12 };
		int[] a3 = new int[] { Graph.MAX, Graph.MAX, 0, 22, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, 8 };
		int[] a4 = new int[] { Graph.MAX, Graph.MAX, 22, 0, 20, Graph.MAX, Graph.MAX, 16, 21 };
		int[] a5 = new int[] { Graph.MAX, Graph.MAX, Graph.MAX, 20, 0, 26, Graph.MAX, 7, Graph.MAX };
		int[] a6 = new int[] { 11, Graph.MAX, Graph.MAX, Graph.MAX, 26, 0, 17, Graph.MAX, Graph.MAX };
		int[] a7 = new int[] { Graph.MAX, 16, Graph.MAX, Graph.MAX, Graph.MAX, 17, 0, 19, Graph.MAX };
		int[] a8 = new int[] { Graph.MAX, Graph.MAX, Graph.MAX, 16, 7, Graph.MAX, 19, 0, Graph.MAX };
		int[] a9 = new int[] { Graph.MAX, 12, 8, 21, Graph.MAX, Graph.MAX, Graph.MAX, Graph.MAX, 0 };

		graph.m[0] = a1;
		graph.m[1] = a2;
		graph.m[2] = a3;
		graph.m[3] = a4;
		graph.m[4] = a5;
		graph.m[5] = a6;
		graph.m[6] = a7;
		graph.m[7] = a8;
		graph.m[8] = a9;

		dgf.graph = graph;
		dgf.prim();
	}
}
