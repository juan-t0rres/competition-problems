import java.util.*;

public class sqfree {
    public static boolean isSquare(double x){ 
        double root = Math.sqrt(x); 
        return ((root - Math.floor(root)) == 0); 
    } 

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int[] squares = new int[10000001];
        for(int i = 1; i <= 1000000; i++){
            squares[i] = squares[i-1];
            if(isPerfectSquare(i)){
                squares[i]++;
            }
        }
        int n = kb.nextInt();
        for(int T = 0; T < n; T++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            System.out.println((b-a+1)-(squares[b] - squares[a-1]));
        }
    }
}