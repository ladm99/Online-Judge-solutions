import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			int n = in.nextInt();
			if(n == 0){return;}

			int a = 0, b = 0;
			boolean aNext = true;

			for(int i = 0; i < 31; i++){
				if((n & (1 << i)) != 0){
					if(aNext){
						a |= (1 << i);
					}else{
						b |= (1 << i);
					}
					aNext = !aNext;
				}
				
			}

			System.out.println(a + " " + b);
		}
	}
}