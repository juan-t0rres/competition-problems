import java.util.*;

public class classy {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numCases = Integer.parseInt(kb.nextLine());
		
		for(int loop = 0; loop < numCases; loop++) {
			int n = Integer.parseInt(kb.nextLine());
			ArrayList<person> people = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				String inp = kb.nextLine();
				people.add(new person(inp));
			}
			Collections.sort(people);
			for(person p: people) {
				System.out.println(p.name);
			}
			System.out.println("==============================");
		}
	}
}

class person implements Comparable<person>{
	String name;
	int[] c;
	
	public person(String inp) {
		int x = inp.indexOf(":");
		int y = inp.indexOf("class");
		String n = inp.substring(0,x);
		this.name = n;
		String[] cls = inp.substring(x+2,y-1).split("-");
		c = new int[10];
		int j = cls.length-1;
		for(int i = 0; i < c.length; i++) {
			if(j >= 0) {
				char s = cls[j].charAt(0);
				if(s == 'u')
					c[i] = 3;
				if(s == 'm')
					c[i] = 2;
				if(s == 'l')
					c[i] = 1;
				j--;
			}
			else {
				c[i] = 2;
			}
		}
	}

	@Override
	public int compareTo(person b) {
		for(int i = 0; i < 10; i++) {
			if(this.c[i] > b.c[i]) {
				return -1;
			}
			if(this.c[i] < b.c[i]) {
				return 1;
			}
		}
		return this.name.compareTo(b.name);
	}
}
