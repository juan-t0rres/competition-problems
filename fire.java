import java.util.*;

public class fire {

    static int R;
    static int C;

    public static boolean isValid(int row, int col, char[][] map, boolean[][] visited){
        if(!inBounds(row,col))
            return false;
        return !visited[row][col] && (map[row][col] == '.' || map[row][col] == 'F');
    }

    public static boolean inBounds(int row, int col){
        return row >= 0 && row < R && col >= 0 && col < C;
    }

    public static void floodfill(char[][] map, boolean[][] visited, int row, int col, int dr, int dc){
        map[row][col] = 'F';
        visited[row][col] = true;
        int nR = row + dr;
        int nC = col + dc;
        if(isValid(nR,nC,map,visited)){
            floodfill(map,visited,nR,nC,dr,dc);
            int lR = row + dc;
            int lC = col + dr;
            int rR = row - dc;
            int rC = col - dr;
            if(isValid(lR,lC,map,visited))
                floodfill(map,visited,lR,lC,dr,dc);
            if(isValid(rR,rC,map,visited))
                floodfill(map,visited,rR,rC,dr,dc);
        }
    }

    public static void solve(char[][] map, int row, int col){
        char dragon = map[row][col];
        boolean[][] visited = new boolean[R][C];
        int dr = 0;
        int dc = 0;
        if(dragon == 'V')
            dr = 1;
        if(dragon == '>')
            dc = 1;
        if(dragon == '^')
            dr = -1;
        if(dragon == '<')
            dc = -1;
        if(isValid(row+dr,col+dc,map,visited)){
            floodfill(map,visited,row+dr,col+dc,dr,dc);
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int num_cases = Integer.parseInt(kb.nextLine());
        for(int case_index = 1; case_index <= num_cases; case_index++){
            String[] inp = kb.nextLine().split(" ");
            R = Integer.parseInt(inp[0]);
            C = Integer.parseInt(inp[1]);
            char[][] map = new char[R][C];
            for(int i = 0; i < R; i++){
                map[i] = kb.nextLine().toCharArray();
            }

            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    if(map[r][c] != '.' && map[r][c] != 'F' && map[r][c] != 'X')
                        solve(map,r,c);
                }
            }

            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    System.out.print(map[r][c]);
                }
                System.out.println();
            }
        }
    }
}