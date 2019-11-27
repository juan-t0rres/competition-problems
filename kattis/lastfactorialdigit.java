import java.util.*;

public class lastfactorialdigit {
	public static int solve(int n) {
		int p = 1;
		for(int i = 1; i <= n; i++) {
			p *= i;
		}
		return p%10;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++) {
			int n = kb.nextInt();
			System.out.println(solve(n));
		}
	}
}
