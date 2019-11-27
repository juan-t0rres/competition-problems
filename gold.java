import java.util.*;

public class gold {

    public static int solve(int[] bags, int start, int end, int[][] memo){
        if(memo[start][end] != -1)
            return memo[start][end];
        if(start == end)
            return bags[start];
        if(start+1 == end)
            return Math.max(bags[start],bags[end]);

        int s = bags[start] + Math.min(solve(bags,start+2,end,memo),
                                        solve(bags,start+1,end-1,memo));
        int e = bags[end] + Math.min(solve(bags,start,end-2,memo),
                                        solve(bags,start+1,end-1,memo));
        memo[start][end] = Math.max(s,e);
        return memo[start][end];
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for(int loop = 0; loop < numCases; loop++){
            int n = kb.nextInt(); // num bags
            int[] bags = new int[n];
            int[][] memo = new int[n][n];
            int sum = 0;
            for(int i = 0; i < n; i++){
                Arrays.fill(memo[i],-1);
                bags[i] = kb.nextInt();
                sum += bags[i];
            }

            int g = solve(bags,0,n-1,memo);
            System.out.println(g-(sum-g));
        }
    }
}
