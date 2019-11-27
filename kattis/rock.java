import java.util.*;
import java.io.*; 

public class rock{
	public static int match(String move1, String move2){
		if((move1.equals("rock") && move2.equals("scissors")) || (move1.equals("paper") && move2.equals("rock")) || (move1.equals("scissors") && move2.equals("paper")))
			return 1;
		if((move2.equals("rock") && move1.equals("scissors")) || (move2.equals("paper") && move1.equals("rock")) || (move2.equals("scissors") && move1.equals("paper")))
			return 2;
		return 0;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = 0;
		if(n!=0)
			k = Integer.parseInt(inp[1]);
		boolean first = true;
		while(n!=0){
			if(first)
				first = false;
			else
				System.out.println();
			int[] wins = new int[n+1];
			int[] losses = new int[n+1];
			int games = k*n*(n-1)/2;
			for(int i=0; i < games; i++){
				inp = br.readLine().split(" ");
				int p1 = Integer.parseInt(inp[0]);
				int p2 = Integer.parseInt(inp[2]);
				int m = match(inp[1],inp[3]);
				if(m==1){
					wins[p1]++;
					losses[p2]++;
				}
				else if(m==2){
					losses[p1]++;
					wins[p2]++;
				}
			}
			for(int i=1; i <=n; i++){
				int w = wins[i];
				int l = losses[i];
				if(w+l == 0){
					System.out.println("-");
				}
				else{
					System.out.println(String.format("%.3f", (double)w/(w+l)));
				}
			}
			inp = br.readLine().split(" ");
			if(inp[0].equals("0"))
				break;
			n = Integer.parseInt(inp[0]);
			k = Integer.parseInt(inp[1]);
		}
	}
}