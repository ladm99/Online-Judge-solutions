import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] chimps = new int[n];
		for(int i = 0; i < n; i++){chimps[i] = in.nextInt();}

		int q = in.nextInt();
		int[] queries = new int[q];
		for(int i = 0; i < q; i++){queries[i] = in.nextInt();}

		for(int query: queries){
			int taller = 0;
			int shorter = 0;
			for(int chimp: chimps){
				if(chimp < query){
					shorter = chimp;
				}
				else if(chimp > query){
					taller = chimp;
					break;
				}

			}
			if(taller == 0){System.out.println(shorter + " X");}
			else if(shorter == 0){System.out.println("X " + taller);}
			else{System.out.println(shorter + " " + taller);}
		}	

	}
}