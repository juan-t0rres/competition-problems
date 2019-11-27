import java.util.*;

public class piggy {

    static int[] memo;

    public static int solve(coin[] coins,int weight){
        if(weight < 0){
           return Integer.MAX_VALUE/2; 
        }
        if(weight == 0){
            return 0;
        }
        if(memo[weight] != -1){
            return memo[weight];
        }
        int min = Integer.MAX_VALUE/2;
        for(int i = 0; i < coins.length; i++){
            coin c = coins[i];
            int t = c.value + solve(coins,weight-c.weight);
            if(t < min)
                min = t;
        }
        memo[weight] = min;
        return memo[weight];
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int num_cases = kb.nextInt();
        for(int T = 0; T < num_cases; T++){
            int e = kb.nextInt();
            int f = kb.nextInt();
            int weight = f-e;
            int n = kb.nextInt();
            coin[] coins = new coin[n];
            for(int i = 0; i < n; i++){
                coins[i] = new coin(kb.nextInt(),kb.nextInt());
            }
            memo = new int[weight+1];
            Arrays.fill(memo,-1);
            int ans = solve(coins,weight);
            if(ans == Integer.MAX_VALUE/2)
                System.out.println("This is impossible.");
            else
                System.out.println("The minimum amount of money in the piggy-bank is " + ans + ".");
        }
    }
}

class coin {
    int value;
    int weight;
    coin(int v, int w){this.value=v;this.weight=w;}
}