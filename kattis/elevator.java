import java.util.*;

public class elevator {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        String[] inp = kb.nextLine().split(" ");
        int floors = Integer.parseInt(inp[0]);
        int start = Integer.parseInt(inp[1]);
        int goal = Integer.parseInt(inp[2]);
        int up = Integer.parseInt(inp[3]);
        int down = Integer.parseInt(inp[4]);
        
        int pos = start;
        int count = 0;
        
        while(pos != goal && count < floors){
            if(pos > goal){
                pos = pos-down;
                count++;
            }
            if(pos < goal){
                pos = pos+up;
                count++;
            }
        }
        if(count >= floors)
            System.out.println("use the stairs");
        else
            System.out.println(count);
    }
}