import java.util.*;

class bunnies {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static boolean inBounds(int row, int col, int rowMax, int colMax){
        return row >= 0 && row < rowMax && col >= 0 && col < colMax;
    }

    public static boolean solve(char[][] cage, boolean[][] visited, int row, int col, char target){
        if(cage[row][col] == target)
            return true;
        visited[row][col] = true;
        boolean found = false;
        for(int i = 0; i < dx.length; i++){
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if(inBounds(newRow,newCol,cage.length,cage[0].length) && !visited[newRow][newCol]
            && cage[newRow][newCol]!='#')
                found = found || solve(cage,visited,newRow,newCol,target);
            if(found)
                return true;
        }
        return found;
    }

    public static int[] findItem(char[][] grid, char x){
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == x)
                    return new int[]{r,c};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numCases = Integer.parseInt(kb.nextLine());
        for(int loop = 0; loop < numCases; loop++){
            String[] inp = kb.nextLine().split(" ");
            int r = Integer.parseInt(inp[0]);
            int c = Integer.parseInt(inp[1]);

            char[][] cage = new char[r][c];

            for(int i = 0; i < r; i++){
                cage[i] = kb.nextLine().toCharArray();
            }

            int[] p = findItem(cage,'P');
            boolean[][] visited = new boolean[r][c];
            boolean ans = solve(cage,visited,p[0],p[1],'C');

            System.out.println(ans ? "yes" : "no");
        }
    }
}