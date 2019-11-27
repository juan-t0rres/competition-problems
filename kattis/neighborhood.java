import java.util.*;

public class neighborhood {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num houses
        int k = kb.nextInt(); // num safe houses
        boolean[] houses = new boolean[n];
        for(int i = 0; i < k; i++) {
            int h = kb.nextInt();
            houses[h-1] = true;
        }
        long count = 0;
        int last = -1; // -1 if we haven't seen safe house
        for(int i = n-1; i >= 0; i--) {
            if(houses[i]) {
                last = i;
            }
            if(last == -1) {
                continue;
            }
            count += (n-i) - (last-i);
        }
        System.out.println(count);
    }
}