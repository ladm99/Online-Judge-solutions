import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		for(int testCase = 1; ; ++testCase){
			if(in.hasNextInt()){
				int n = in.nextInt(), m = in.nextInt(); //n = number of vessels, m = number of containers

				int[] vessels = new int[n];

				for(int i = 0; i < n; i++){
				vessels[i] = in.nextInt();
				}

				ArrayList<Integer> containers = new ArrayList<Integer>();

				int lower = 0;
				int upper = 0;

				for(int vessel : vessels){
					if(vessel > lower){lower = vessel;}
					upper+=vessel;
				}

				int upperIndex = (upper-lower); //index of the upper value
				int lowerIndex = 0; //index of lower value
				while(lowerIndex < upperIndex){
					int midPoint = (lowerIndex + upperIndex)/2;
					int count = 1; // keeps track of the number of containers needed
					int fill = 0; //keeps track of how full the container is
					for(int item : vessels){
						if(fill + item > (midPoint+lower)){
							count++;
							fill = item;
						} else{fill+=item;}
					}
					if(count <= m){upperIndex = midPoint;}
					else{lowerIndex = midPoint + 1;}
				}
				System.out.println(lowerIndex+lower);
			}else{return;}
		}
	}
}