import java.util.*;

public class polling {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String name = kb.next();
            if(map.containsKey(name))
                map.put(name,map.get(name)+1);
            else
                map.put(name,1);
        }

        int max = 0;
        for(String key: map.keySet()){
            if(map.get(key)>max)
                max = map.get(key);
        }

        for(String key: map.keySet()){
            if(map.get(key)==max)
                System.out.println(key);
        }
    }
}
