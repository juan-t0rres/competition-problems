import java.util.*;

public class sums {
	public static int T(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++) {
			int n = kb.nextInt();
			int ans = 0;
			for(int k = 1; k <= n; k++) {
				ans += k*T(k+1);
			}
			System.out.println((loop+1) + " " + n + " " + ans);
		}
	}
}
