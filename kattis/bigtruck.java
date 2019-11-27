import java.util.*;

public class bigtruck {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // num vertices
		int[] items = new int[n+1];
		for(int i = 1; i <= n; i++) {
			items[i] = kb.nextInt();
		}
		int m = kb.nextInt(); // num edges
		
		int[][] adj = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int d = kb.nextInt();
			adj[a][b] = d;
			adj[b][a] = d;
		}
		
		int[][] distance = new int[n+1][n+1];
		int[][] i2 = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					distance[i][j] = 0;
					i2[i][j] = 0;
				}
				else if(adj[i][j] > 0) {
					distance[i][j] = adj[i][j];
					i2[i][j] = items[j];
				}
				else {
					distance[i][j] = Integer.MAX_VALUE/2;
					i2[i][j] = Integer.MIN_VALUE/2;
				}
			}
		}
		
		for(int p = 1; p <= n; p++) {
			for(int s = 1; s <= n; s++) {
				for(int d = 1; d <= n; d++) {
					if(distance[s][d] > distance[s][p] + distance[p][d]) {
						distance[s][d] = distance[s][p] + distance[p][d];
						i2[s][d] = i2[s][p] + i2[p][d];
					}
					else if(distance[s][d] == distance[s][p] + distance[p][d]) {
						if(i2[s][d] < i2[s][p] + i2[p][d]) {
							i2[s][d] = i2[s][p] + i2[p][d];
						}
					}
				}
			}
		}
		
		if(distance[1][n] >= Integer.MAX_VALUE/2) {
			System.out.println("impossible");
		}
		else {
			System.out.println(distance[1][n] + " " + (i2[1][n] + items[1]));
		}
	}
}
