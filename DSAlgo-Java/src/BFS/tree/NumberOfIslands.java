//https://www.geeksforgeeks.org/find-number-of-islands/

package BFS.tree;

public class NumberOfIslands {
	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println(countNumberOfIslands(M));
	}

	public static boolean isSafeToVisit(int row, int ROW, int col, int COL, int M[][], boolean visited[][]) {
		return (row >= 0 && row < ROW) && (col >= 0 && col < COL) && (M[row][col] == 1) && !(visited[row][col]);
	}

	public static void BFSIteration(int row, int col, boolean visited[][], int[][] M) {
		visited[row][col] = true;
		int rowPosition[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int colPosition[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
		int ROW = M.length;
		int COL = M[0].length;

		/**
		 * figure out the respective neighbors and mark them as visited as they are part
		 * of single island
		 */
		for (int index = 0; index < rowPosition.length; index++) {
			int currentRow = row + rowPosition[index];
			int currentCol = col + colPosition[index];
			if (isSafeToVisit(currentRow, ROW, currentCol, COL, M, visited)) {
				BFSIteration(currentRow, currentCol, visited, M);
			}
		}
	}

	public static int countNumberOfIslands(int M[][]) {
		int countNumberOfIslands = 0;
		boolean visited[][] = new boolean[M.length][M[0].length];

		for (int index = 0; index < M.length; index++) {
			for (int jindex = 0; jindex < M[0].length; jindex++) {
				if (M[index][jindex] == 1 && !visited[index][jindex]) {
					BFSIteration(index, jindex, visited, M);
					countNumberOfIslands++;
				}
			}
		}

		return countNumberOfIslands;
	}
}


// https://leetcode.com/problems/number-of-islands/submissions/
