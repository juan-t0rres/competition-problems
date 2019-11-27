import java.util.*;

public class yellowcards {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numPlayers1 = s.nextInt();
		int numPlayers2 = s.nextInt();
		int maxYellow1 = s.nextInt();
		int maxYellow2 = s.nextInt();
		int yellowCards = s.nextInt();
		
		int[] team1 = new int[numPlayers1];
		int[] team2 = new int[numPlayers2];
		int yc = yellowCards;
		for(int i = 0; i < team1.length && yc > 0; i++) {
			while(team1[i] != maxYellow1-1 && yc > 0) {
				yc--;
				team1[i]++;
			}
		}
		for(int i = 0; i < team2.length && yc > 0; i++) {
			while(team2[i] != maxYellow2-1 && yc > 0) {
				yc--;
				team2[i]++;
			}
		}
		int min = yc;
		yc = yellowCards;
		int z = Integer.min(maxYellow1,maxYellow2);
		int p = 0;
		int player = 0;
		int max = 0;
		if(z == maxYellow1)
			p = numPlayers1;
		else
			p = numPlayers2;
		while(yc > 0 && p > 0) {
			yc--;
			player++;
			if(player == z) {
				p--;
				max++;
				player = 0;
			}
		}
		if(z == maxYellow1) {
			z = maxYellow2;
			p = numPlayers2;
		}
		else {
			z = maxYellow1;
			p = numPlayers1;
		}
		while(yc > 0 && p > 0) {
			yc--;
			player++;
			if(player == z) {
				max++;
				p--;
				player = 0;
			}
		}
		System.out.println(min + " " + max);
	}
}
