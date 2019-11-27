import java.util.*;

public class precomp {
	public static void solve(int n, int k, int num) {
		if(k == n) {
			if(num%k == 0)
				System.out.println(num);	
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			if(k==0 && i==0)
				continue;
			int t = num*10+i;
			if(t%(k+1) == 0) {
				solve(n,k+1,t);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for(int i = 0; i < t; i++) {
			int n = kb.nextInt();
			solve(n,0,0);
		}	
	}
}
