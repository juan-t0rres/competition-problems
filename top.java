import java.util.*;

public class top {
	public static void main(String[] args){
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String[] a = new String[n];
		String[] b = new String[n];
		for(int i = 0; i < n; i++)
			a[i] = kb.next();
		for(int i = 0; i < n; i++)
			b[i] = kb.next();

		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < a.length; i++){
			if(a[i].equals(b[i])){
				ans.add(1);
				continue;
			}
			int count = 0;
			while(i < a.length && !a[i].equals(b[i])){
				count++;
				i++;
			}
			ans.add(count);
			i--;
		}
		for(int x: ans)
			System.out.println(x);
	}
}