package tech.interview.problems.graph;

import java.util.Iterator;

public class DetectCycleUnDirectedGraph {

    public static void main(String[] args) {
                Graph g = new Graph(4);
                g.addEdgeBoth( 0, 1);
                g.addEdgeBoth( 0, 2);
                g.addEdgeBoth( 1, 2);
                g.addEdgeBoth( 2, 0);
                g.addEdgeBoth( 2, 3);
                g.addEdgeBoth( 3, 3);
                if (isCyclic(g))
                    System.out.println("Graph contains cycle");
                else
                    System.out.println("Graph doesn't contain cycle");
            }
    public static boolean isCyclic(Graph g){
        if(g == null)
            return false;
        boolean[] visited = new boolean[g.V];
        for(int i = 0; i < g.V; i++){
            visited[i] = false;
        }
        for(int i = 0; i < g.V; i++){
            if(!visited[i] && DFS(g, i, - 1, visited)){
                return true;
            }
        }
        return false;
    }

    public static boolean DFS(Graph g, int i, int parent, boolean[] visited){
        visited[i] = true;
        Iterator<Integer> itr = g.adj[i].listIterator();
        while(itr.hasNext()){
            int v = itr.next();
            if(!visited[v] && DFS(g, v, i, visited))
                return true;
            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if(v != parent)
                return true;
        }
        return false;
    }
}
