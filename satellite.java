import java.util.*;
/*
public class satellite {

    public static double mst(ArrayList<edge> list, int n) {
        Collections.sort(list);

        dset trees = new dset(n);
        int numEdges = 0;
        double res = 0;

        for (int i=0; i<list.size(); i++) {

            boolean merged = trees.union(list.get(i).v1, list.get(i).v2);
            if (!merged) continue;

            numEdges++;
            res += list.get(i).w;
            if (numEdges == n-1) break;
        }

        return numEdges == n-1 ? res : -1;
    }

    public static double distance(int x1, int x2, int y1, int y2){
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num vertices
        int[][] coords = new int[n][2];
        int[] radius = new int[n];

        for(int i = 0; i < n; i++){
            coords[i][0] = kb.nextInt(); // x
            coords[i][1] = kb.nextInt(); // y
            radius[i] = kb.nextInt();
        }

        ArrayList<edge> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                int x1 = coords[i][0];
                int x2 = coords[j][0];
                int y1 = coords[i][1];
                int y2 = coords[j][1];
                double w = distance(x1,x2,y1,y2) - radius[i] - radius[j];
                edges.add(new edge(i,j,w));
            }
        }

        System.out.println(mst(edges,n));
    }
}

class dset {

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

class edge implements Comparable<edge> {

    public int v1;
    public int v2;
    public double w;

    public edge(int a, int b, double weight) {
        v1 = a;
        v2 = b;
        w = weight;
    }

    public int compareTo(edge other) {
        if(this.w > other.w)
            return 1;
        if(this.w < other.w)
            return -1;
        return 0;
    }
}
*/