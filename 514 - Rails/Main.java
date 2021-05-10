import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for(;;){
			int n = in.nextInt();
			
			if(n == 0){
				//System.out.println("");
				break;}

				for(;;){
					Stack<Integer> a = new Stack<>();
					int car = in.nextInt();

					if(car == 0){
						System.out.println("");
						break;
					}

						a.push(car);
					
					for(int z = 1; z < n; z++){
						car = in.nextInt();
						a.push(car);
					}

					Stack<Integer> b = new Stack<>();
					b.push(a.pop());
					int i = n;

					for(;;){
						if(b.peek() == i){
							while(!b.empty() && b.peek() == i){
								b.pop();
								i--;
							}

						}
						if(a.empty() && b.empty()){
							System.out.println("Yes");
							break;
						}else if(a.empty() && !b.empty()){
							System.out.println("No");
							break;
						}
						
						if(!a.empty()){
							b.push(a.pop());
						}
					}
				}
			}

		}
	}