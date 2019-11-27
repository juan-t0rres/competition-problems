import java.util.*;

public class minion {
	public static boolean dfs(int[][] adj, int[] used, int pos, int n) {
		boolean found = false;
		
		if(pos == n-1)
			return true;
		
		for(int i = 0; i < n; i++) {
			if(adj[pos][i] == 1 && used[i] != 1) {
				used[i] = 1;
				found = dfs(adj,used,i,n);
				if(!found)
					used[i] = 0;
				else
					return true;
			}
		}
		
		return found;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int m = kb.nextInt();
		for(int loop = 0; loop < m; loop++) {
			int t = kb.nextInt();
			HashSet<String> trials = new HashSet<String>();
			for(int i = 0; i < t; i++)
				trials.add(kb.next());
			int n = kb.nextInt();
			int e = kb.nextInt();
			int[][] adj = new int[n][n];
			int[] used = new int[n];
			used[0] = 1;
			
			for(int i = 0; i < e; i++) {
				int l1 = kb.nextInt();
				int l2 = kb.nextInt();
				String trial = kb.next();
				if(!trials.contains(trial)) {
					adj[l1][l2] = 1;
					adj[l2][l1] = 1;
				}
			}
			if(dfs(adj,used,0,n))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}