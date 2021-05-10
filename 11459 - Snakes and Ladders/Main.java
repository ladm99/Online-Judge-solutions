import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int testCase = 1; testCase <= t; testCase++){
			int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(); //a = players, b = snakes/ladders, c = die rolls
			int[] positions = new int[a];

			for(int i = 0; i < a; i++){
				positions[i] = 1;
			}

			int[] start = new int[b];
			int[] end = new int[b];

			for(int i = 0; i < b; i++){
				start[i] = in.nextInt();
				end[i] = in.nextInt();
			}

			boolean gameOver = false;
			int playerIndex = 0;
			int rollCount = 0;
			int roll;
			
			if(a == 0) {
				gameOver = true;
				roll = in.nextInt();
				rollCount++;

				while(rollCount < c) {
					roll = in.nextInt();
					rollCount++;
				}
			}else {
				while(!gameOver){

					for(int i = 0; i < c; i++){
						roll = in.nextInt();
						if(playerIndex == a){
							playerIndex = 0;
						}

						positions[playerIndex]+=roll;

						

						for(int x = 0; x < start.length; x++){
							if(positions[playerIndex] == start[x]){
								positions[playerIndex] = end[x];
								break;
							}
							
						}

						if(positions[playerIndex] >= 100){
							positions[playerIndex] = 100;
							gameOver = true;
							break;

						}

						playerIndex++;
						rollCount++;

					}
					gameOver = true;
				}
				while(rollCount < c - 1) {
					roll = in.nextInt();
					rollCount++;
				}
			}

			for(int z = 0; z < a; z++){
				System.out.println("Position of player " + (z+1) + " is " + positions[z] + ".");
			}
		}
	}
}