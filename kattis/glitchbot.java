import java.util.*;

public class glitchbot {

    public static int[] location(char[] moves){
        int x = 0;
        int y = 0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
        int direction = 0;
        for(char ch: moves){
            if(ch == 'L'){
                direction = direction == 0 ? 3 : direction-1;
            }
            else if(ch == 'R'){
                direction = direction == 3 ? 0 : direction+1;
            }
            else {
                x += d[direction][0];
                y += d[direction][1];
            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        int y = kb.nextInt();
        int n = kb.nextInt();
        char[] moves = new char[n];
        for(int i = 0; i < n; i++){
            moves[i] = kb.next().charAt(0);
        }

        int line = 0;
        char d = 'L';
        for(int i = 0; i < n; i++){
            char original = moves[i];
            moves[i] = 'L';
            int[] l = location(moves);
            moves[i] = 'R';
            int[] r = location(moves);
            moves[i] = 'F';
            int[] f = location(moves);
            if(l[0] == x && l[1] == y){
                d = 'L';
                line = i+1;
                break;
            }
            if(r[0] == x && r[1] == y){
                d = 'R';
                line = i+1;
                break;
            }
            if(f[0] == x && f[1] == y){
                d = 'F';
                line = i+1;
                break;
            }
            moves[i] = original;
        }
        String direction = "";
        if(d == 'L')
            direction = "Left";
        if(d == 'R')
            direction = "Right";
        if(d == 'F')
            direction = "Forward";

        System.out.println(line + " " + direction);
    }
}