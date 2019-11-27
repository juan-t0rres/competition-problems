import java.util.*;

public class tacobell {

	static ArrayList<String> ans;

	public static void combine(int pos, int k, int n, boolean[] used, String[] items){
		if(k == n){
			StringBuilder str = new StringBuilder();
			for(int i = 0; i < used.length; i++){
				if(used[i])
					str.append(items[i] + " ");
			}
			ans.add(str.toString());
			return;
		}

		if(pos >= items.length)
			return;

		// skip
		used[pos] = false;
		combine(pos+1,k,n,used,items);

		// use k element
		used[pos] = true;
		combine(pos+1,k+1,n,used,items);
		used[pos] = false;
	}


	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		for(int case_index = 0; case_index < t; case_index++){
			int n = kb.nextInt();
			int k = kb.nextInt();
			ans = new ArrayList<>();
			String[] items = new String[n];
			for(int i = 0; i < n; i++){
				items[i] = kb.next();
			}
			Arrays.sort(items);
			boolean[] used = new boolean[n];
			combine(0,0,k,used,items);
			Collections.sort(ans);
			for(String s: ans){
				System.out.println(s);
			}

			System.out.println();
		}
	}
}