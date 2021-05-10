import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNext()){
			int n = in.nextInt(), m = in.nextInt();

			int[] moves = new int[m];
			for(int i =0; i < m; i++){
				moves[i] = in.nextInt();
			}

			boolean[] curPlayerWins = new boolean[n+1];

			curPlayerWins[0] = false;

			for(int i = 1; i <= n; i++){
				for(int j = 0; j< m; j++){
					if(i >= moves[j] && !curPlayerWins[i - moves[j]]){
						curPlayerWins[i] = true;
						break;
					}

				}
			}

			System.out.println(curPlayerWins[n] ? "Stan wins" : "Ollie wins");
		}
	}
}