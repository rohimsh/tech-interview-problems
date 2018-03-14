package graph;

import java.util.Iterator;

public class DFS {

public static void main(String[] args) {
	
	Graph g = new Graph(4);
	 
	g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    
    DFS(2, g);
    
}

public static void DFS(int s, Graph g) {
	boolean visited[] = new boolean[g.V];
	DFSUtil(s, visited, g);
/*	 for (int i = 0; i < g.V; i++)
	        if (visited[i] == false)
	            DFSUtil(i, visited, g);*/
}

private static void DFSUtil(int s, boolean[] visited, Graph g) {
	
		visited[s] = true;
		System.out.print(s + " ");
		
		Iterator<Integer> itr = g.adj[s].listIterator();
		while(itr.hasNext()) {
			int node = itr.next();
			if(!visited[node])
				DFSUtil(node, visited, g);
		}	
}
	
}
