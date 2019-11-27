import java.util.*;

public class ingestion {
	
	static int m;
	
	static long[][][] memo;
	
	public static long solve(int[] courses, int k, int calories, int prevEat) {
		if(k >= courses.length)
			return 0;
		
		if(memo[k][calories][prevEat] != -1) {
			return memo[k][calories][prevEat];
		}
		
		// a: case 1 where you eat kth course
		int c1 = (int)(calories*2.0/3.0);
		long a = Math.min(courses[k], calories) + solve(courses,k+1,c1,1);
		
		// b: case 2 where you skip kth course
		long b;
		
		// if you ate last course and you skip this one, calories you can eat increases
		if(prevEat == 1) {
			int c2 = (int)(calories*3.0/2.0);
			b = solve(courses,k+1,c2,0);
		}
		// if you skipped last course and you skip this one, calories goes back to m
		else {
			b = solve(courses,k+1,m,0);
		}
		
		memo[k][calories][prevEat] = Math.max(a, b);
		return memo[k][calories][prevEat];
	}
	
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		m = kb.nextInt();
		int[] courses = new int[n];
		for(int i = 0; i < n; i++) {
			courses[i] = kb.nextInt();
		}
		memo = new long[courses.length+1][m+1][2];
		for(int i = 0; i < memo.length; i++) {
			for(int j = 0; j < memo[i].length; j++) {
				Arrays.fill(memo[i][j], -1);
			}
		}
		
		long ans = solve(courses,0,m,0);
		System.out.println(ans);
	}
}
