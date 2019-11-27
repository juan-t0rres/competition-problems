import java.util.*;

public class warehouse {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int numCases = kb.nextInt();
		for(int loop = 0; loop < numCases; loop++) {
			int n = kb.nextInt();
			ArrayList<toy> toys = new ArrayList<toy>();
			HashSet<String> seen = new HashSet<String>();
			for(int i = 0; i < n; i++) {
				String name = kb.next();
				int count = kb.nextInt();
				if(seen.contains(name)) {
					for(toy t: toys) {
						if(t.name.equals(name)) {
							t.count += count;
							break;
						}
					}
				}
				else {
					toys.add(new toy(name,count));
					seen.add(name);
				}
			}
			Collections.sort(toys);
			System.out.println(toys.size());
			for(toy t: toys)
				System.out.println(t.name + " " + t.count);
		}
	}
}

class toy implements Comparable<toy>{
	String name;
	int count;
	
	public toy(String name, int count) {
		this.name = name;
		this.count = count;
	}

	@Override
	public int compareTo(toy ab) {
		int d = ab.count - this.count;
		if(d == 0) {
			return this.name.compareTo(ab.name);
		}
		return d;
	}
}
