import java.util.*;

public class scenes {
    
    public static final int M = 1_000_000_007;

    static int[][] memo;

    public static int solve(int n, int w, int h){
        if(n == 0 || w == 0)
            return 1;

        if(memo[n][w] != -1)
            return memo[n][w];
    
        int ans = 0;
        for(int i = 0; i <= h; i++){
            if(n - i >= 0)
                ans = (ans + solve(n - i, w - 1, h)) % M;
        }
        
        memo[n][w] = ans;
        return ans;
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int w = kb.nextInt();
        int h = kb.nextInt();
        memo = new int[n+1][w+1];
        for(int i = 0; i < n+1; i++)
           Arrays.fill(memo[i],-1);
        System.out.println(solve(n,w,h) - (Math.min(h,n/w)+1));
    }
}