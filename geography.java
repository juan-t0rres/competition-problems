import java.io.*;
import java.util.*;

public class geography {

	public static int dfs(int vertex, ArrayList<Integer>[] adj, boolean[] visited){
		int ans = 0;
		visited[vertex] = true;
		for(int v: adj[vertex]){
			if(!visited[v]){
				ans += 1 + dfs(v,adj,visited);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int numCases = Integer.parseInt(br.readLine());
		for(int loop = 0; loop < numCases; loop++){
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int roads = Integer.parseInt(st.nextToken());

			ArrayList[] adj = new ArrayList[n+1];
			for(int i = 1; i <= n; i++){
				adj[i] = new ArrayList<Integer>();
			}

			for(int i = 0; i < roads; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}

			boolean[] visited = new boolean[n+1];
			int count = 0;
			for(int i = 1; i <= n; i++){
				if(!visited[i]){
					int x = 1 + dfs(i,adj,visited);
					count += (x*(x-1))/2;
				}
			}
			pw.println(count);
		}
		pw.close();
	}
}
