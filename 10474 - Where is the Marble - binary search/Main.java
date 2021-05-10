import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for(int testCase = 1; ; ++testCase){
			int n = in.nextInt(), q = in.nextInt();
			if(n == 0 && q == 0){return;}
			System.out.println("CASE# " + testCase + ":");

			int[] marbles = new int[n];

			for(int i = 0; i < n; i++)
				marbles[i] = in.nextInt();

			Arrays.sort(marbles);

			for(int i = 0; i < q; i++){
				int x = in.nextInt(); //querey

				int l = 0, u = n-1;
				while(l < u){
					int m = (l+u) / 2; //midpoint
					//left = l,...m     right = m+1,....,u
					if(x <= marbles[m]){u = m;}
					else{l = m + 1;}
				}

				if(marbles[u] == x){System.out.println(x + " found at "+ (u + 1));}
				else{System.out.println(x + " not found");}
			}
		}

	}
}