package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	int V;
	List<Integer>[] adj;
	
	public Graph(int v) {
		this.V = v;
		this.adj = new List[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
}
