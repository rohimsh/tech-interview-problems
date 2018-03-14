package graph;

import java.util.Iterator;
import java.util.Stack;

public class TPS{
	public static void main(String[] args) {
		
	    Graph g = new Graph(6);
	    
	    g.addEdge(5, 2);
	    g.addEdge(5, 0);
	    g.addEdge(4, 0);
	    g.addEdge(4, 1);
	    g.addEdge(2, 3);
	    g.addEdge(3, 1);
	    
	    TPS(g);
	}
	
	public static void TPS(Graph g) {
		boolean visited[] = new boolean[g.V];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < g.V; i++)
		        if (!visited[i])
		           TPSUtil(i, visited, stack, g);
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
	}
	
	private static void TPSUtil(int s, boolean[] visited, Stack<Integer> stack, Graph g) {
			
			visited[s] = true;
			
			Iterator<Integer> itr = g.adj[s].listIterator();
			while(itr.hasNext()) {
				int node = itr.next();
				if(!visited[node])
					TPSUtil(node, visited, stack, g);
			}	
			
			stack.push(s);
	}
}
