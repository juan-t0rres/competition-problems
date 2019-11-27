import java.util.*;

public class truedan {

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
            int d = kb.nextInt(); // danny starting location
            int s = kb.nextInt(); // sawyer starting location
            ArrayList<E>[] adj = new ArrayList[n+1];
            for(int i = 1; i <= n; i++){
                adj[i] = new ArrayList<E>();
            }

            for(int i = 0; i < m; i++){
                int a = kb.nextInt();
                int b = kb.nextInt();
                int w = kb.nextInt();
                adj[a].add(new E(b,w));
                adj[b].add(new E(a,w));
            }

            int[] ans = new int[]{s,d};
            boolean[] used = new boolean[2];

            shortestPath(1,ans,used,adj);

            if(ans[0] == s)
                ans[0] = Integer.MAX_VALUE;
            if(ans[1] == d)
                ans[1] = Integer.MAX_VALUE;
            else
                ans[1] *= 2;

            if(ans[0] <= ans[1]){
                System.out.println("Sawyer's style is undeniable!");
            }
            else{
                System.out.println("I can't believe Danny won!");
            }
        }
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
