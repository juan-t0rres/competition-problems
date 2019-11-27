import java.util.*;
public class scramble{

    public static int getVal(char ch){
        if(ch == ' ') return 0;
        return ch - 'a' + 1;
    }

    public static char getChar(int n){
        if(n == 0) return ' ';
        return (char)(n - 1 + 'a');
    }

    public static String encode(String str){
        int[] u = new int[str.length()];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int v = getVal(ch);
            int prev = 0;
            if(i > 0){
                prev = u[i-1];
            }
            u[i] = v + prev;
            sb.append(getChar(u[i]%27));
        }
        return sb.toString();
    }

    public static String decode(String str){
        int[] vals = new int[str.length()];
        int x = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int val = getVal(ch);
            val -= x;
            while(val < 0) val += 27;
            vals[i] = val;
            x += val;
            sb.append(getChar(vals[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int num_cases = Integer.parseInt(kb.nextLine());
        for(int loop = 0; loop < num_cases; loop++){
            String inp = kb.nextLine();
            char ch = inp.charAt(0);
            if(ch == 'e'){
                System.out.println(encode(inp.substring(2)));
            }
            if(ch == 'd'){
                System.out.println(decode(inp.substring(2)));
            }
        }
    }
}