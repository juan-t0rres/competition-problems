import java.util.*;

// multiple source/destination shortest path
public class routes {
    /*
    public static void shortestPath(int source, int[] destinations, boolean[] used, ArrayList<E>[] adj){
        boolean[] visited = new boolean[adj.length];
        PriorityQueue<E> pq = new PriorityQueue<>();

        pq.add(new E(source,0));

        while(!pq.isEmpty()){
            E curr = pq.poll();

            if(visited[curr.d])
                continue;

            visited[curr.d] = true;

            for(int i = 0; i < destinations.length; i++){
                if(curr.d == destinations[i] && !used[i]) {
                    destinations[i] = curr.w;
                    used[i] = true;
                }
            }

            for(E edge: adj[curr.d]){
                if(!visited[edge.d]){
                    pq.add(new E(edge.d,edge.w + curr.w));
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for(int loop = 0; loop < numCases; loop++){
            int n = kb.nextInt(); // num vertices
            int m = kb.nextInt(); // num edges
            int q = kb.nextInt(); // num sources

            ArrayList<E>[] adj = new ArrayList[n+1];
            for(int i = 1; i <= n; i++)
                adj[i] = new ArrayList<E>();

            for(int i = 0; i < m; i++){
                int v1 = kb.nextInt();
                int v2 = kb.nextInt();
                int w = kb.nextInt();
                adj[v1].add(new E(v2,w));
                adj[v2].add(new E(v1,w));
            }

            int[] housing = new int[q];
            boolean[] used = new boolean[q];
            for(int i = 0; i < q; i++){
                housing[i] = kb.nextInt();
            }
            shortestPath(1,housing,used,adj);
            for(int x: housing){
                System.out.println(x);
            }
        }
    }
     */
}

/*
// edge class
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
*/