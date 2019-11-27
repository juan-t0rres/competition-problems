import java.util.*;
public class profits {

    public static int mcss(int[] arr){
        int sum = 0;
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum > max){
                max = sum;
            }
            else if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        while(n != 0){
            int[] p = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = kb.nextInt();
            }
            System.out.println(mcss(p));
            n = kb.nextInt();
        }
    }
}