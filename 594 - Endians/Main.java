import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			if(!in.hasNextInt()){return;}
			int n = in.nextInt();

			int reverse = 0;

			for(int i =  0; i < 4; i++){

				for(int x = 0; x < 8; x++) {

					if(((i * 7) + i + x) <= 7) {
						if((n & (1 << (x))) != 0){
							reverse |= (1 << (x + 24));
						}
					}else if(((i * 7) + i + x) <= 15 && ((i * 7 ) + i + x) > 7) {
						if((n & (1 << ((i * 7) + i + x)))!= 0){
							reverse |= (1 << (x+16));
						}
					} else if(((i * 7) + i + x) <= 23 && ((i * 7) + i + x) > 15) {

						if((n & (1 << ((i * 7) + i + x))) != 0){
							reverse |= (1 << (x + 8));
						}
					} else {
						if((n & (1 << ((i * 7) + i + x))) != 0) {
							reverse |= (1 << (x));
						}	
					}
				}

			}
			System.out.println(n + " converts to " + reverse);
		}
	}
}