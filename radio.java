import java.util.*;

public class radio {

	static long[] memo;

	public static long solve(prize[] prizes, int k){
		if(k == prizes.length)
			return 0;

		if(memo[k] != -1)
			return memo[k];

		// case 1: win this prize
		int nextDay = prizes[k].day + prizes[k].wait;
		long win = prizes[k].value;
		for(int i = k+1; i < prizes.length; i++){
			if(nextDay <= prizes[i].day){
				win += solve(prizes,i);
				break;
			}
		}

		// case 2: skip this prize
		long skip = solve(prizes,k+1);

		memo[k] = Math.max(win,skip);
		return memo[k];
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++){
			int k = kb.nextInt();
			prize[] prizes = new prize[k];
			memo = new long[k];
			Arrays.fill(memo,-1);
			for(int i = 0; i < k; i++)
				prizes[i] = new prize(kb.nextInt(),kb.nextInt(),kb.nextInt());
			Arrays.sort(prizes);
			System.out.println(solve(prizes,0));
		}
	}
}

class prize implements Comparable<prize>{
	int day;
	int value;
	int wait;

	public prize(int d, int v, int w){
		day = d;
		value = v;
		wait = w;
	}

	@Override
	public int compareTo(prize b){
		return this.day - b.day;
	}
}