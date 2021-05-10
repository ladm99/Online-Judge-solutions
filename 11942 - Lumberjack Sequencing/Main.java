import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); //number of groups
		ArrayList<String> results = new ArrayList<String>();

		for(int group = 1; group <= n; group++){
			boolean orderedLong = true;
			boolean orderedShort = true;

			int num = in.nextInt(); //current number
			for(int i = 2; i <= 10; i++ ){
				int current = in.nextInt();
				
				if(num < current){orderedLong = false;}
				if(num > current){orderedShort = false;}

				num = current;
			}
			if(orderedLong || orderedShort){
				results.add("Ordered");
				//System.out.println("Ordered");
			} else{
				results.add("Unordered");
				//System.out.println("Unordered");
			}
		}
		System.out.println("Lumberjacks:");

		for (String result : results)
			System.out.println(result);
	}
}