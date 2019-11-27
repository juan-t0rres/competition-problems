import java.util.*;

public class calc {

    public static final int M = 1000000;
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int num_cases = kb.nextInt();
        for(int T = 0; T < num_cases; T++){
            int a = kb.nextInt(); // add a
            int b = kb.nextInt(); // multiply by b
            int c = kb.nextInt(); // int division by c
            int target = kb.nextInt();
            int[] nums = new int[1000000];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            Arrays.fill(nums,Integer.MAX_VALUE);
            queue.add(0);
            nums[0] = 0;
            while(!queue.isEmpty()){
                int n = queue.poll();
                int add = (n + a) % M;
                int mult = (n * b) % M;
                int div = (n / c) % M;
                if(nums[add] == Integer.MAX_VALUE){
                    nums[add] = nums[n] + 1;
                    queue.offer(add);
                }
                if(nums[mult] == Integer.MAX_VALUE){
                    nums[mult] = nums[n] + 1;
                    queue.offer(mult);
                }
                if(nums[div] == Integer.MAX_VALUE){
                    nums[div] = nums[n] + 1;
                    queue.offer(div);
                }
            }
            int ans = nums[target] == Integer.MAX_VALUE ? -1 : nums[target];
            System.out.println(ans);
        }
    }

}