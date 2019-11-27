import java.util.*;

public class smallschedule {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int q = kb.nextInt(); // time
        int m = kb.nextInt(); // num machines
        int s = kb.nextInt(); // num 1 second
        int l = kb.nextInt(); // num q second
        
        long time = 0;
        
        int x = l/m;
        int r = l%m;
        
        time += x*q;
        if(r != 0) {
        	int spaces = m - r;
        	s -= q*spaces;
        	time += q;
        }
        
        if(s > 0) {
        	time += s/m;
        	if(s%m > 0)
        		time++;
        }
        
        System.out.println(time);
    }
}