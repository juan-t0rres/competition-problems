import java.util.*;

public class neighbor {
    public static int solve(int[] houses, int k, int took, int[][] memo){
        if(k < 0)
            return 0;
        if(memo[k][took] != -1)
            return memo[k][took];

        // case 1: take the money at kth house
        // only possible if you didn't take last house.
        int t = 0;
        if(took != 1)
            t = houses[k] + solve(houses,k-1,1,memo);

        // case 2: skip this house
        int s = solve(houses,k-1,0,memo);

        memo[k][took] = Math.max(t,s);
        return memo[k][took];
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for(int c = 1; c <= numCases; c++){
            int k = kb.nextInt(); // num houses
            int[] houses = new int[k];
            int[][] memo = new int[k][2];
            for(int i = 0; i < k; i++) {
                houses[i] = kb.nextInt();
                Arrays.fill(memo[i],-1);
            }

            int max = solve(houses,k-1,0,memo);
            System.out.println(max);
        }
    }
}
