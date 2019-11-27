import java.util.*;

public class exam {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int k = Integer.parseInt(kb.nextLine());
        char[] m = kb.nextLine().toCharArray();
        char[] f = kb.nextLine().toCharArray();
        int same = 0;
        int n = m.length;
        for(int i = 0; i < n; i++){
            if(m[i] == f[i]){
                same++;
            }
        }
        System.out.println(Math.min(same,k) + (n-k) - Math.max(0,same-k));
    }
}