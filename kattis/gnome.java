import java.util.*;

public class gnome {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numCases = kb.nextInt();
        for(int loop = 0; loop < numCases; loop++){
            int n = kb.nextInt();
            int[] gnomes = new int[n];
            for(int i = 0; i < n; i++){
                gnomes[i] = kb.nextInt();
            }

            int ans = gnomes.length-2;
            int prev = 0;
            for(int i = 1; i < gnomes.length-1; i++){
                if(gnomes[i] < gnomes[prev]){
                    int next = i+1;
                    
                    if(gnomes[next] > gnomes[prev])
                        ans = i;
                    else
                        ans = prev;

                    break;
                }
                prev++;
            }
            System.out.println(ans+1);
        }
    }

}