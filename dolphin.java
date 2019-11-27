import java.util.*;

public class dolphin {

	static int[][][] memo;

	public static int solve(int[] food, int k, int p, int dec){
		if(k == food.length)
			return 0;

		if(memo[k][p][dec] != -1)
			return memo[k][p][dec];

		// case 1: add this to our sequence
		// if it makes it decreasing, update dec
		int a = 0;
		if(food[k] >= food[p]){
			if(dec != 1)
				a += 1 + solve(food,k+1,k,0);
			else if(food[k] == food[p])
				a += 1 + solve(food,k+1,k,1);
		}
		else {
			a += 1 + solve(food,k+1,k,1);
		}

		// case 2: skip this value
		int b = solve(food,k+1,p,dec);

		memo[k][p][dec] = Math.max(a,b);
		return memo[k][p][dec];
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int c = 1; c <= numCases; c++){
			int n = kb.nextInt();
			int[] food = new int[n+1];
			food[0] = Integer.MIN_VALUE;
			memo = new int[n+1][n+1][2];
			for(int i = 0; i < memo.length; i++){
				for(int j = 0; j < memo[i].length; j++){
					Arrays.fill(memo[i][j],-1);
				}
			}
			for(int i = 1; i <= n; i++){
				food[i] = kb.nextInt();
			}

			int ans = solve(food,1,0,0);
			System.out.println("Case " + c + ":");
			System.out.println("Dynamo ate " + ans + " food pellet(s).");
			System.out.println();
		}
	}
}