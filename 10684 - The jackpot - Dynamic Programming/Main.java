import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			int n = in.nextInt();
			if(n == 0){return;}

			int[] a = new int[n];
			boolean hasPositive = false;
			for(int i = 0; i < n; i++){
				a[i] = in.nextInt();
				if(a[i] > 0){
					hasPositive = true;
				}
			}

			if(!hasPositive){
				System.out.println("Losing streak.");
				continue;
			}

			int[] subProbs = new int[n];

			subProbs[0] = a[0];

			int best = subProbs[0];
			for(int i = 1; i < n; i++){
				if(subProbs[i-1] <= 0){
					subProbs[i] = a[i];
				}else{
					subProbs[i] = subProbs[i-1] + a[i];
				} 
				if(subProbs[i] > best){best = subProbs[i];}
			}

		System.out.println("The maximum winning streak is " + best + ".");
	}
}
}