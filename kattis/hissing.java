import java.util.*;
public class hissing {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        char[] str = kb.nextLine().toCharArray();
        boolean hiss = false;
        for(int i = 0; i < str.length-1; i++){
            if(str[i] == 's' && str[i+1] == 's'){
                hiss = true;
                break;
            }
        }
        System.out.println(hiss ? "hiss" : "no hiss");
    }
}