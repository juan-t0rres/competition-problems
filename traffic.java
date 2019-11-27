import java.util.*;

public class traffic {

	public static int dfs(ArrayList<Integer>[] adj, boolean[] used, int k, int closed){
		int ans = 0;
		for(int x: adj[k]){
			if(x != closed && !used[x]){
				used[x] = true;
				ans += 1 + dfs(adj,used,x,closed);
			}
		}
		return ans;
	}

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++){
			int n = kb.nextInt();
			ArrayList<Integer>[] adj = new ArrayList[n+1];
			for(int i = 1; i <= n; i++)
				adj[i] = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++){
				int l = kb.nextInt();
				for(int j = 0; j < l; j++){
					int x = kb.nextInt();
					adj[i].add(x);
					adj[x].add(i);
				}
			}
			int c = kb.nextInt();
			System.out.println("City #" + (loop+1));
			for(int i = 0; i < c; i++){
				int closed = kb.nextInt();
				boolean yes = false;
				for(int j = 1; j <= n; j++){
					if(j != closed){
						boolean[] used = new boolean[n+1];
						int x = dfs(adj,used,j,closed);
						used = new boolean[n+1];
						int y = dfs(adj,used,j,-1);
						if(y-x > 1){
							yes = true;
							break;
						}
					}
				}
				System.out.println(yes ? "yes" : "no");
			}
			System.out.println();
		}
	}
}
