import java.io.*;
import java.util.*;

public class sudoku {

	public static final int N = 9;
	public static PrintWriter pw = new PrintWriter(System.out);

	public static boolean canPlace(int num, int[][] grid, int row, int col){
		// check row
		for(int i = 0; i < N; i++){
			if(i == row)
				continue;
			if(num == grid[i][col])
				return false;
		}

		// check col
		for(int i = 0; i < N; i++){
			if(i == col)
				continue;
			if(num == grid[row][i])
				return false;
		}

		// check box
		int r = (row/3) * 3;
		int c = (col/3) * 3;
		for(int i = r; i < r + 3; i++){
			for(int j = c; j < c + 3; j++){
				if(i == row && j == col)
					continue;
				if(grid[i][j] == num)
					return false;
			}
		}
					
		return true;
	}

	public static boolean solve(int[][] grid, int r, int c){
		if(r == N)
			return true;

		int nextC = c + 1;
		int nextR = r;
		if(nextC == N){
			nextC = 0;
			nextR++;
		}

		if(grid[r][c] != 0)
			return solve(grid,nextR,nextC);

		boolean solved = false;
		for(int i = 1; i <= N; i++){
			if(canPlace(i,grid,r,c)){
				grid[r][c] = i;
				solved = solve(grid,nextR,nextC);
			}
			if(solved)
				break;
			grid[r][c] = 0;
		}
		return solved;
	}

	public static void printGrid(int[][] grid){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++)
				pw.print(grid[i][j] + " ");
			pw.println();
		}
	}

	public static boolean solve(int[][] grid){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(grid[i][j] == 0)
					continue;
				if(!canPlace(grid[i][j], grid, i, j))
					return false;
			}
		}
		solve(grid,0,0);			
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num_cases = Integer.parseInt(br.readLine());
		for(int case_index = 1; case_index <= num_cases; case_index++){
			br.readLine();
			int[][] grid = new int[N][N];
			for(int i = 0; i < N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					grid[i][j] = Integer.parseInt(st.nextToken());
			}
			boolean solvable = solve(grid);
			pw.println("Test case " + case_index + ":");
			if(solvable)
				printGrid(grid);
			else 
				pw.println("No solution possible.");
			pw.println();
		}
		pw.close();
	}
}