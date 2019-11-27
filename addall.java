import java.util.*;

public class addall {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++) {
			int n = kb.nextInt();
			
			PriorityQueue<Long> nums = new PriorityQueue<Long>();
			for(int i = 0; i < n; i++)
				nums.add((long)kb.nextInt());
			
			if(nums.size()==1) {
				System.out.println(nums.poll());
				continue;
			}
			
			long cost = 0;
			
			while(nums.size() > 1) {
				long n1 = nums.poll();
				long n2 = nums.poll();
				long sum = n1 + n2;
				cost += sum;
				nums.add(sum);
			}
			
			System.out.println(cost);
		}
	}
}

