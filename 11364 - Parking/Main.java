import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt(); //number of test cases

		for (int testCase = 1; testCase <= t; ++testCase){
			int n = in.nextInt(); //number of stores
			int min = in.nextInt(), max = min;

			for (int i = 2; i <= n; i++){
				int current = in.nextInt();
				if(current < min){
					min = current;
				} else if(current > max){
					max = current;
				}
			}
			System.out.println(2 * (max - min));
		}

	}
}