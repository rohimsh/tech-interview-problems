package tech.interview.problems.graph;

import java.util.Arrays;

public class PrimsMST {

	public static void main(String[] args) {
	    int[][] graph = new int[][] {{0, 2, 0, 6, 0},
						            {2, 0, 3, 8, 5},
						            {0, 3, 0, 0, 7},
						            {6, 8, 0, 0, 9},
						            {0, 5, 7, 9, 0},
						           };
	    PrimsMST(graph, 0);
	}
	
	public static void PrimsMST(int[][] graph, int source) {
		int V = graph.length;
		boolean[] path = new boolean[V];
		int[] dist = new int[V];
		int[] parent = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		
		dist[source] = 0;
		
		for(int i = 0; i < V - 1; i++) {
		
			int u = minDistanceNode(dist, path);
			path[u] = true;
			
			for(int v = 0; v < V; v++) {
				if(!path[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[v] > graph[u][v]) {
					dist[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}
		printPath(graph, parent);
	}


	public static int minDistanceNode(int[] dist, boolean[] path) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		
		for(int i = 0; i < dist.length; i++) {
			if(!path[i] && dist[i] <= min) {
				min = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	
	private static void printPath(int[][] graph, int[] parent) {
		
		for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i]+" - "+ i+"    "+ graph[i][parent[i]]);
	}

	
}
