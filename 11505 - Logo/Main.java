import java.util.*;
import java.lang.Math;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		for(int testCases = 1; testCases <= t; testCases++){
			int c = in.nextInt();

			String[] commands = new String[c];
			int[] moves = new int[c];

			for(int i = 0; i < c; i++){
				commands[i] = in.next();
				moves[i] = in.nextInt();
			}

			double distance = 0;
			double x = 0, y = 0;
			int angle = 0;
			for(int i = 0; i < commands.length; i++){

				switch(commands[i]){
				case "lt":
					angle += moves[i];
					break;

				case "rt":
					angle -= moves[i];
					break;

				case "fd":
					distance = moves[i];
					x += (distance * Math.cos(Math.toRadians(angle))); //figures out the x and y values from the angles
					y += (distance * Math.sin(Math.toRadians(angle)));
					break;

				case "bk":
					distance = moves[i];
					x -= (distance * Math.cos(Math.toRadians(angle)));
					y -= (distance * Math.sin(Math.toRadians(angle)));
					break;
				}
			}

			System.out.println((int) Math.round(df(x,y)));

		}
	}
	public static double df(double x, double y){
		//start x,y = 0,0
		double distanceBetweenPoints = Math.sqrt((Math.pow(y,2) + Math.pow(x,2)));
		return distanceBetweenPoints;
	}
}