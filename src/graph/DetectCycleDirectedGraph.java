package graph;

import java.util.Iterator;

public class DetectCycleDirectedGraph {
    private static int WHITE = -1;
    private static int GREY = 0;
    private static int BLACK = 1;

    public static void main(String[] args) {
                Graph g = new Graph(4);
                g.addEdge( 0, 1);
                g.addEdge( 0, 2);
                g.addEdge( 1, 2);
                g.addEdge( 2, 0);
                g.addEdge( 2, 3);
                g.addEdge( 3, 3);
                if (isCyclic(g))
                    System.out.println("Graph contains cycle");
                else
                    System.out.println("Graph doesn't contain cycle");
            }
    public static boolean isCyclic(Graph g){
        if(g == null)
            return false;
        int[] color = new int[g.V];
        for(int i = 0; i < g.V; i++){
            color[i] = WHITE;
        }

        for(int i = 0; i < g.V; i++){
            if(color[i] == WHITE && DFS(g, i, color)){
                return true;
            }
        }
        return false;
    }

    public static boolean DFS(Graph g, int i, int[] color){
        color[i] = GREY;
        Iterator<Integer> itr = g.adj[i].listIterator();
        while(itr.hasNext()){
            int v = itr.next();
            if(color[v] == GREY)
                return true;
            if(color[v] == WHITE && DFS(g, v, color))
                return true;
        }
        color[i] = BLACK;
        return false;
    }
}
