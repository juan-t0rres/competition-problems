import java.util.*;

public class countseq {

	static long memo[][];

	public static long solve(char[] inp, char[] sub, int pos, int k){
		if(k == sub.length)
			return 1;
		if(pos == inp.length)
			return 0;
		if(memo[pos][k] != -1)
			return memo[pos][k];

		// case 1: take this letter, only if it is the kth letter
		long take = 0;
		if(inp[pos] == sub[k])
			take = solve(inp,sub,pos+1,k+1);

		// case 2: skip this letter
		long skip = solve(inp,sub,pos+1,k);

		memo[pos][k] = take + skip;
		return memo[pos][k];
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		
		for(int loop = 0; loop < numCases; loop++){
			String inp = kb.next();
			String sub = kb.next();
			memo = new long[inp.length()][sub.length()];
			for(int i = 0; i < memo.length; i++)
				Arrays.fill(memo[i],-1);
			System.out.println(solve(inp.toCharArray(),sub.toCharArray(),0,0));
		}
	}
}