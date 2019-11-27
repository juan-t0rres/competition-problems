import java.util.*;

public class xkcd {
	static Set<Character> vowels = new HashSet<>() {{
		add('a');
		add('e');
		add('i');
		add('o');
		add('u');
		add('y');
	}};

	static TreeSet<String> ans;

	public static void solve(int k, int n, int[] x, int sum){
		if(k == n && sum == 42){
			StringBuilder str = new StringBuilder();

			for(int i = 0; i < x.length-1; i++){
				char ch = (char)(x[i] + 'a' - 1);
				if(i == x.length-2){
					char ch2 = (char)(x[i+1] + 'a' - 1);
					str.append(ch2);
				}
				str.append(ch);
			}

			ans.add(str.toString());
			return;
		}

		if(k >= n || sum >= 42){
			return;
		}

		int prev = k > 0 ? x[k-1]-1 : 'z' - 'a' + 1;
		for(int i = prev; i >= 1; i--){
			char ch = (char)(i + 'a' - 1);
			if(!vowels.contains(ch)){
				x[k] = i;
				solve(k+1,n,x,sum+i);
			}
		}

	}


	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		while(n != 42){
			if(n >= 8){
				System.out.println("Mostly Harmless");
				n = kb.nextInt();
				continue;
			}

			ans = new TreeSet<>();
			solve(0,n,new int[n],0);
			System.out.println("XKCD-like name(s) of length: " + n);
			if(ans.size() == 0)
				System.out.println("Mostly Harmless");
			else{
				for(String x: ans){
					System.out.println(x);
				}
			}

			n = kb.nextInt();
		}
		System.out.println("The answer to life, the universe and everything!");
	}
}