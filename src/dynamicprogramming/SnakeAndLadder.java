package dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author rohitmishra
 * @see https://www.geeksforgeeks.org/snake-ladder-problem-2/
 */
public class SnakeAndLadder {
	
	public static void main(String[] args) {
			int N = 30;
	        int moves[] = new int[N];
	        for (int i = 0; i < N; i++)
	            moves[i] = -1;
	 
	        // Ladders
	        moves[2] = 21;
	        moves[4] = 7;
	        moves[10] = 25;
	        moves[19] = 28;
	 
	        // Snakes
	        moves[26] = 0;
	        moves[20] = 8;
	        moves[16] = 3;
	        moves[18] = 6;
	 
	        System.out.println("Min Dice throws required is " + 
	                          getMinDiceThrows(moves, N));
	}

	static class BoardCell{
		private int v;
		private int dist;
	}
	
	private static int getMinDiceThrows(int[] moves, int n) {
		Queue<BoardCell> queue = new LinkedList<BoardCell>();
		boolean[] visited = new boolean[n];
		BoardCell source = new BoardCell();
		source.v = 0; 
		source.dist = 0;
		queue.add(source);
		visited[0] = true;

		while(!queue.isEmpty()) {
			
			source = queue.poll();
			int v = source.v;
			if(v == n - 1) {
				System.out.println("Reached Destination!");
				break;
			}
			
			for(int i = (v + 1); i <= (v + 6) && i < n; i++) {
				if(!visited[i]) {
					BoardCell nextNode = new BoardCell();
					nextNode.dist = source.dist + 1;
					visited[i] = true;
					
					if(moves[i] != -1) {
						nextNode.v = moves[i];
					} else {
						nextNode.v = i;
					}
					queue.add(nextNode);
				}
			}
		}
		
		return source.dist;
	}

}
