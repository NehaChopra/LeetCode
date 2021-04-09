/*
 * https://www.geeksforgeeks.org/program-for-conways-game-of-life/
 * 
 * Initially, there is a grid with some cells which may be alive or dead. Our task to generate the next generation of cells based on the following rules:

	Any live cell with fewer than two live neighbors dies, as if caused by under population.
	Any live cell with two or three live neighbors lives on to the next generation.
	Any live cell with more than three live neighbors dies, as if by overpopulation.
	Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	Examples:
	The ‘*’ represent an alive cell and the ‘.’ represent a dead cell.
	
	Input : ..........
	        ...**.....
	        ....*.....
	        ..........
	        ..........
	Output: ..........
	        ...**.....
	        ...**.....
	        ..........
	        ..........
	        ..........
	
	Input : ..........
	        ...**.....
	        ....*.....
	        ..........
	        ..........
	        ...**.....
	        ..**......
	        .....*....
	        ....*.....
	        ..........
	Output: ..........
	        ...**.....
	        ...**.....
	        ..........
	        ..........
	        ..***.....
	        ..**......
	        ...**.....
	        ..........
	        ..........
 * 
 */
package Arrays;

public class ConwaysGameOfLife {
	public static void main(String[] args) {
		int M = 10, N = 10;

		// Intiliazing the grid.
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		// Displaying the grid
		System.out.println("Original Generation");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		int[][] future = nextGeneration(grid, M, N);

		System.out.println("Next Generation");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (future[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}

	public static int[][] nextGeneration(int[][] grid, int M, int N) {
		int[][] future = new int[M][N];
		int[] Row = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] Col = { -1, 0, 1, 1, 1, 0, -1, -1 };
		for (int index = 0; index < M; index++) {
			for (int jindex = 0; jindex < N; jindex++) {
				int aliveNeighbours = 0;
				for (int i = 0; i < Row.length; i++) {
					if (isSafe(index + Row[i], jindex + Col[i], M, N)) {
						System.out.println(grid[index + Row[i]][jindex + Col[i]]);
						aliveNeighbours = aliveNeighbours + grid[index + Row[i]][jindex + Col[i]];

						// Cell is lonely and dies
						if ((grid[index][jindex] == 1) && (aliveNeighbours < 2))
							future[jindex][jindex] = 0;

						// Cell dies due to over population
						else if ((grid[jindex][jindex] == 1) && (aliveNeighbours > 3))
							future[jindex][jindex] = 0;

						// A new cell is born
						else if ((grid[jindex][jindex] == 0) && (aliveNeighbours == 3))
							future[jindex][jindex] = 1;

						// Remains the same
						else
							future[jindex][jindex] = grid[jindex][jindex];
					}
				}
			}
		}
		return future;

	}

	public static boolean isSafe(int row, int col, int M, int N) {
		if (row < 0 || col < 0 || row >= M || col >= N) {
			return false;
		}
		return true;
	}

}
