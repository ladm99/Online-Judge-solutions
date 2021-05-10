import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for(int testCase = 1; testCase <= t; testCase++){
			int n = in.nextInt();
			String[] instructions = new String[n];
			int position = 0;
			
			in.nextLine(); //using nextLine after nextInt will return an empty string
			for(int i = 0; i < n; i++){
				instructions[i] = in.nextLine().trim();
			}

			for(int i = 0; i < n; i++){
				if(step(instructions[i], instructions).equals("LEFT")){position--;}
				else if(step(instructions[i], instructions).equals("RIGHT")){position++;}
				
			}

			System.out.println(position);
		}
	}

	public static String step(String x, String[] instructions){
		if(x.equals("LEFT")){
			return "LEFT";
		} else if(x.equals("RIGHT")){
			return "RIGHT";}
			int num = Integer.parseInt(x.substring((x.lastIndexOf(" ") + 1))) - 1;
			return step(instructions[num], instructions);

	}
}