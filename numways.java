import java.util.*;

public class numways {

    static int[][] memo;

    static int m = 1000000007;

    public static int numWays(int amount, int[] coins, int k){
        if(amount == 0)
            return 1;
        if(amount < 0 || k == coins.length)
            return 0;
        if(memo[amount][k] != -1)
            return memo[amount][k];

        memo[amount][k] = (numWays(amount-coins[k],coins,k)%m)
                + (numWays(amount,coins,k+1)%m);
        return memo[amount][k];
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for(int loop = 0; loop < numCases; loop++){
            int amt = kb.nextInt();
            int d = kb.nextInt();
            int[] coins = new int[d];
            for(int i = 0; i < d; i++){
                coins[i] = kb.nextInt();
            }
            memo = new int[amt+1][coins.length];
            for(int i = 0; i < memo.length; i++)
                Arrays.fill(memo[i],-1);
            int ans = numWays(amt,coins,0)%m;
            System.out.println(ans);
        }
    }
}
