package graph;

import java.util.Arrays;

public class Dijkstra {

	public static void main(String[] args) {
	    int[][] graph = new int[][]{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
						            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
						            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
						            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
						            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
						            { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
						            { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
						            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
						            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Dijkstra(graph, 0);
	}
	
	public static void Dijkstra(int[][] graph, int source) {
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
				if(!path[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v]) {
					dist[v] = dist[u] + graph[u][v];
					parent[v] = u;
				}
			}
		}
		printPath(dist, parent);
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
	
	
	private static void printPath(int[] dist, int[] parent) {
		
		for(int i = 0; i < dist.length; i++) {
			System.out.print(i + " - > " + dist[i] + " ");
			printParent(i, parent);
			System.out.println();
		}
	}

	private static void printParent(int s, int[] parent) {
		if(parent[s] == -1) 
			return;
		printParent(parent[s], parent);
		System.out.print(s+" ");
	}
	
	
	
}
