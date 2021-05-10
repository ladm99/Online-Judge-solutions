import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for(int testCase = 1; ; testCase++){
			int n = in.nextInt();
			if(n == 0){return;}
			System.out.println("Output for data set " + testCase +", "+ n + " bytes:");

			int bytesSoFar = 0, bytesLastFive = 0, seconds = 0;

			while(bytesSoFar < n){
				int bytes = in.nextInt();
				bytesSoFar+= bytes;
				bytesLastFive+= bytes;
				seconds++;

				if(seconds % 5 == 0){
					System.out.print("   Time remaining: ");
					if(bytesLastFive == 0){
						System.out.println("stalled");
					} else{
						System.out.println(divRoundUp((n - bytesSoFar) * 5, bytesLastFive) + " seconds");
						bytesLastFive = 0;
					}
				}
			}
			System.out.println("Total time: " + seconds + " seconds\n"); 
		}
	}

	public static int divRoundUp(int a, int b){
		return a % b == 0 ? a / b : a / b + 1;
	}
}