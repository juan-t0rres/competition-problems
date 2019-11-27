import java.util.*;

public class kinds {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,1,-1};

    public static boolean inBounds(int r, int c, int maxR, int maxC){
        return r >= 0 && r < maxR && c >=0 && c < maxC;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int r = kb.nextInt();
        int c = kb.nextInt();
        int[][] map = new int[r][c];
        for(int i = 0; i < r; i++){
            String str = kb.next();
            for(int j = 0; j < str.length(); j++){
                int v = Character.getNumericValue(str.charAt(j));
                map[i][j] = v;
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int r1 = i;
                int c1 = j;
                int val = map[r1][c1];
                ArrayDeque<Integer> qr = new ArrayDeque<>();
                ArrayDeque<Integer> qc = new ArrayDeque<>();
                qr.add(r1);
                qc.add(c1);
                while(!qr.isEmpty()){
                    int r2 = qr.poll();
                    int c2 = qc.poll();
                }
            }
        }

        int n = kb.nextInt();
        for(int i = 0; i < n; i++){
            int r1 = kb.nextInt()-1;
            int c1 = kb.nextInt()-1;
            int r2 = kb.nextInt()-1;
            int c2 = kb.nextInt()-1;
            int start = map[r1][c1];
        }
    }
}