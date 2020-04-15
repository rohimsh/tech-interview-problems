package tech.interview.problems.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
	
 public static void main(String[] args) {
	 Graph g = new Graph(6);
	 
     g.addEdge(5, 2);
     g.addEdge(5, 0);
     g.addEdge(4, 0);
     g.addEdge(4, 1);
     g.addEdge(2, 3);
     g.addEdge(3, 1);

     TopologicalSorting(g);
}
 
 public static void TopologicalSorting(Graph g) {
	 
	 int[] indegree = new int[g.V];
	 Queue<Integer> queue = new LinkedList<Integer>();
	 
	 for(int i = 0; i < g.V; i++) {
		 Iterator<Integer> itr = g.adj[i].listIterator();
		 while(itr.hasNext()) {
			 int node = itr.next();
			 indegree[node]++;
		 }
	 }
	 
	 for(int i = 0; i < indegree.length; i++) {
		 if(indegree[i] == 0)
			 queue.add(i);
	 }
	 
	 while(!queue.isEmpty()) {
		 
		 int s = queue.poll();
		 System.out.print(s + " ");
		 Iterator<Integer> itr = g.adj[s].listIterator();
		 while(itr.hasNext()) {
			 int node = itr.next();
			 indegree[node]--;
			 if(indegree[node] == 0)
				 queue.add(node);
		 }
	 }
 }
}
