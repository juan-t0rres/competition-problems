import java.util.*;

public class relocation {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // num companies
		int q = kb.nextInt(); // num requests
		
		int[] locations = new int[n+1];
		for(int i = 0; i < n; i++) {
			int l = kb.nextInt();
			locations[i+1] = l;
		}
		
		for(int i = 0; i < q; i++) {
			int request = kb.nextInt();
			int a = kb.nextInt();
			int b = kb.nextInt();
			
			if(request == 1) {
				locations[a] = b;
			}
			else {
				System.out.println(Math.abs(locations[a]-locations[b]));
			}
		}
	}
}
