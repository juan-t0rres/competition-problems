import java.util.*;

public class lex {
    
    public static int[] findItem(char[][] grid, char ch){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == ch){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static boolean inBounds(int row, int col, int maxRow, int maxCol){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static int floodfill(char[][] grid, boolean[][] visited, int row, int col){
        visited[row][col] = true;
        int ans = 0;
        for(int i = 0; i < 4; i++){
            int nextR = row + dr[i];
            int nextC = col + dc[i];
            if(inBounds(nextR,nextC,grid.length,grid[0].length) && !visited[nextR][nextC] && grid[nextR][nextC] == '~'){
                ans += 1 + floodfill(grid,visited,nextR,nextC);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int num_cases = Integer.parseInt(kb.nextLine());
        for(int case_index = 0; case_index < num_cases; case_index++){
            String[] inp = kb.nextLine().split(" ");
            int r = Integer.parseInt(inp[0]);
            int c = Integer.parseInt(inp[1]);
            char[][] grid = new char[r][c];
            for(int i = 0; i < r; i++){
                grid[i] = kb.nextLine().toCharArray();
            }
            int[] x = findItem(grid,'X');
            boolean[][] visited = new boolean[r][c];
            int ans = 5 * (floodfill(grid,visited,x[0],x[1]) + 1);
            System.out.println(ans);
        }
    }
}