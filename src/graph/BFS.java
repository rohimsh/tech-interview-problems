package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
	    g.addEdge(0, 2);
	    g.addEdge(1, 2);
	    g.addEdge(2, 0);
	    g.addEdge(2, 3);
	    g.addEdge(3, 3);
	    
	    BFS(2, g);
	    
	}

	private static void BFS(int u, Graph g) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[g.V];
		queue.add(u);
		visited[u] = true;
		while(!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> itr = g.adj[s].listIterator();
			while(itr.hasNext()) {
				int node = itr.next();
				if(!visited[node]) {
					queue.add(node);
					visited[node] = true;
				}		
			}
			}
	}
	
	
}
