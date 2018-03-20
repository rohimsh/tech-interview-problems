package graph;

public class CountIslands {
	public static void main(String[] args) {
		int arr[][]=  new int[][] {{1, 1, 0, 0, 0},
									{0, 1, 0, 0, 1},
									{1, 0, 0, 1, 1},
									{0, 0, 0, 0, 0},
									{1, 0, 1, 0, 1}
					           	   };
		System.out.println(findNumberOfIslands(arr));
	}

	private static int findNumberOfIslands(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		int count = 0;
		boolean visited[][] = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					DFS(arr, visited, i, j, m, n);
					count++;
				}
			}
		}
		
		return count;
	}

	private static void DFS(int[][] arr, boolean[][] visited, int row, int col, int m, int n) {
		int[] x = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		int[] y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0; i < 8; i++) {
			int rowX = row + x[i];
			int colY = col + y[i];
			if(rowX >= 0  && rowX < m && colY >=0 && colY < n && !visited[rowX][colY] && arr[rowX][colY] == 1) {
				visited[rowX][colY] = true;
				DFS(arr, visited, rowX, colY, m, n);
			}
		}
	}

}
