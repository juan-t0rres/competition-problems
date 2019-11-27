import java.util.*;

public class frogman {

    static int[][][] memo;

    public static int solve(cylinder[] cyl, int k, int t, int a){
        if(t == 0 && a == 0)
            return 0;
        if(k == cyl.length)
            return Integer.MAX_VALUE/2;
        if(memo[k][t][a] != -1)
            return memo[k][t][a];
        cylinder c = cyl[k];
        int take = c.w + solve(cyl,k+1,Math.max(0,t-c.o),Math.max(0,a-c.n));
        int skip = solve(cyl,k+1,t,a);
        memo[k][t][a] = Math.min(take,skip); 
        return memo[k][t][a];
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt(); // oxygen
        int a = kb.nextInt(); // nitrogen
        int n = kb.nextInt(); // num cylinders
        cylinder[] cyl = new cylinder[n];
        for(int i = 0; i < n; i++)
            cyl[i] = new cylinder(kb.nextInt(),kb.nextInt(),kb.nextInt());
        memo = new int[n+1][t+1][a+1];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[i].length; j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        System.out.println(solve(cyl,0,t,a));
    }

}

class cylinder {
    int o; // oxygen
    int n; // nitrogen
    int w; // weight
    cylinder(int o, int n, int w){this.o=o;this.n=n;this.w=w;}
}