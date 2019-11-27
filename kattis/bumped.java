import java.util.*;

public class bumped {

    public static long dijkstras(int source, int destination, ArrayList<E>[] adj){
        boolean[] visited = new boolean[adj.length];
        PriorityQueue<E> pq = new PriorityQueue<>();

        pq.add(new E(source,0));

        while(!pq.isEmpty()){
            E curr = pq.poll();

            if(visited[curr.d])
                continue;

            visited[curr.d] = true;

            if(curr.d == destination) {
                return curr.w;
            }

            for(E edge: adj[curr.d]){
                if(!visited[edge.d]){
                    pq.add(new E(edge.d,edge.w + curr.w));
                }
            }
        }

        return Long.MAX_VALUE;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int f = kb.nextInt();
        int s = kb.nextInt();
        int t = kb.nextInt();

        ArrayList<E>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<E>();
        
        for(int ind = 0; ind < m; ind++){
            int i = kb.nextInt();
            int j = kb.nextInt();
            int c = kb.nextInt();

            adj[i].add(new E(j,c));
            adj[j].add(new E(i,c));
        }
        long minCost = dijkstras(s, t, adj);
        for(int i = 0; i < f; i++){
            int u = kb.nextInt();
            int v = kb.nextInt();
            E utov = new E(v,0);
            adj[u].add(utov);
            long cost = dijkstras(s, t, adj);
            if(cost < minCost) minCost = cost;
            adj[u].remove(utov);
        }
        System.out.println(minCost);
    }
}

class E implements Comparable<E>{
    int d; // destination
    long w; // weight

    E(int d, long w){
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(E b) {
        if(this.w > b.w) return 1;
        if(this.w < b.w) return -1;
        return 0;
    }
}
