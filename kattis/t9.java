import java.util.*;
import java.io.*; 

public class t9 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		String[] keypad = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

		int n = Integer.parseInt(br.readLine());
		for(int i=0; i < n; i++){
			String message = br.readLine();
			String retval = "";
			int len = message.length();
			int pos = -1;
			int num = -1;
			for(int j = 0; j < len; j++){
				char c = message.charAt(j);
				int pnum = num;
				for(int z = 0; z < 10; z++){
					pos = keypad[z].indexOf(c);
					if(pos!=-1){
						num = z;
						break;
					}
				}
				if(num==pnum)
					retval+=" ";
				for(int z=0; z < pos+1; z++)
					retval += ""+num;
			}
			System.out.println("Case #" + (i+1) + ": " + retval);

		}
	}
}