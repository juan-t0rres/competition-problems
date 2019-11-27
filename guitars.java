import java.util.*;
import java.io.*;

public class guitars {
	
	public static int mst(ArrayList<edge> edges, int n) {
		Collections.sort(edges);
		dset DS = new dset(n);
		int cost = 0;
		int numEdges = 0;
		for(edge e: edges) {
			boolean merge = DS.union(e.v1,e.v2);
			if(!merge)
				continue;
			cost += e.w;
			numEdges++;
			if(numEdges == n-2)
				break;
		}
		if(numEdges < n-2)
			return -1;
		return cost;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int loop = 0; loop < t; loop++) {
			String[] inp = br.readLine().split(" ");
			int numStores = Integer.parseInt(inp[0]);
			int numRoutes = Integer.parseInt(inp[1]);
			ArrayList<edge> edges = new ArrayList<edge>();
			int numVertices = 1;
			for(int i = 0; i < numRoutes; i++) {
				inp = br.readLine().split(" ");
				int v1 = Integer.parseInt(inp[0]);
				int v2 = Integer.parseInt(inp[1]);
				int w = Integer.parseInt(inp[2]);
				if(v1 > numVertices)
					numVertices = v1;
				if(v2 > numVertices)
					numVertices = v2;
				edges.add(new edge(v1,v2,w));
			}
			int ans = mst(edges,numVertices+1);
			System.out.println(ans);
		}
	}
	
	static class edge implements Comparable<edge> {
		public int v1;
		public int v2;
		public int w;

		public edge(int a, int b, int weight) {
			v1 = a;
			v2 = b;
			w = weight;
		}

		public int compareTo(edge other) {
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
