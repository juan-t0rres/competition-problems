import java.util.*;

public class grid {

	static int ans;

	public static int shortestPath(int source, int destination, ArrayList<E>[] adj){
        boolean[] visited = new boolean[adj.length];
        PriorityQueue<E> pq = new PriorityQueue<>();

        pq.add(new E(source,0));

        while(!pq.isEmpty()){
            E curr = pq.poll();

            if(visited[curr.d])
                continue;

            visited[curr.d] = true;

            if(curr.d == destination){
            	return curr.w;
            }

            for(E edge: adj[curr.d]){
                if(!visited[edge.d]){
                    pq.add(new E(edge.d,edge.w + curr.w));
                }
            }
        }
        return -1;
    }

	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		String[] inp = kb.nextLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int m = Integer.parseInt(inp[1]);
		ans = Integer.MAX_VALUE;
		int[][] g = new int[n][m];

		ArrayList<E>[] adj = new ArrayList[n*m];
        for(int i = 0; i < n*m; i++)
        	adj[i] = new ArrayList<E>();

		for(int i = 0; i < n; i++){
			char[] line = kb.nextLine().toCharArray();
			for(int j = 0; j < m; j++){
				g[i][j] = Character.getNumericValue(line[j]);
			}
		}

		for(int r = 0; r < n; r++){
			for(int c = 0; c < m; c++){
				int d = g[r][c];
				int[] dx = new int[]{0,0,d,d*(-1)};
				int[] dy = new int[]{d,d*(-1),0,0};
				for(int i = 0; i < 4; i++){
					int newRow = r + dx[i];
					int newCol = c + dy[i];
					if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
						int v1 = m*r + c;
						int v2 = m*newRow + newCol;
						adj[v1].add(new E(v2,1));
					}
				}
			}
		}

		System.out.println(shortestPath(0,n*m-1,adj));
	}
}

class E implements Comparable<E>{
    int d; // destination
    int w; // weight

    E(int d, int w){
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(E b) {
        return this.w-b.w;
    }
}