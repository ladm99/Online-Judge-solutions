import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNextInt()){
			int m = in.nextInt(), n = in.nextInt(), t = in.nextInt();

			int[] subProbs = new int[t+1];
			Arrays.fill(subProbs, -1);

			int best = 0;
			subProbs[0] = 0;
			for(int i = 1 ; i <= t; i++){
				if(i >= n && subProbs[i-n] != -1){
					subProbs[i] = subProbs[i-n] + 1;
				}
				if(i >= m && subProbs[i-m] != -1){
					subProbs[i] = Math.max(subProbs[i], subProbs[i-m] + 1);
				}


			}
			for(int i = t; t > 0; i--) {
				if(subProbs[i] != -1) {
					best =  subProbs[i];
					int beer = t-i;

					if(beer == 0){
						System.out.println(best);
					} else {
						System.out.println(best + " " + beer);
					}
					break;
				}
				
			}

		}

	}
}