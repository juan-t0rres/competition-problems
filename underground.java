import java.util.*;
import java.io.*;

public class underground {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {
			ArrayList<edge> edges = new ArrayList<edge>();
			for(int i = 0; i < n; i++) {
				String[] inp = br.readLine().split(" ");
				int x = Integer.parseInt(inp[0]);
				int y = Integer.parseInt(inp[1]);
			}
		}
	}
	
	static class edge {
		public int v1;
		public int v2;
		public double w;

		public edge(int a, int b, double weight) {
			v1 = a;
			v2 = b;
			w = weight;
		}

		public double compareTo(edge other) {
			return this.w - other.w;
		}
	}
	
	static class dset {
		public int[] parent;
		public int[] height;
		public int n;

		public dset(int size) {
			parent = new int[size];
			height = new int[size];
			for (int i=0; i<size; i++)
				parent[i] = i;
		}

		public int find(int v) {
			if (parent[v] == v) return v;
			parent[v] = find(parent[v]);
			height[v] = 1;
			return parent[v];
		}

		public boolean union(int v1, int v2) {

			int p1 = find(v1);
			int p2 = find(v2);
			if (p1 == p2) return false;

			if (height[p2] < height[p1]) parent[p2] = p1;
			else if (height[p1] < height[p2]) parent[p1] = p2;
			else {
				parent[p2] = p1;
				height[p1]++;
			}
			return true;
		}
	}
}
