import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int testcases = in.nextInt();

		for(int t = 1; t <= testcases; t++){

			int numOfLines = in.nextInt();

			double[][] lines = new double[numOfLines][4];

			for(int r = 0; r < numOfLines; r++){
				for(int c = 0; c < 4; c++){
					lines[r][c] = in.nextDouble();
				}
			}
			int segments = numOfLines;
			boolean bySelf = true;

			for(int r1 = 0; r1 < numOfLines - 1 ; r1++){
				double x1 = lines[r1][0], y1 = lines[r1][1], x2 = lines[r1][2], y2 = lines[r1][3];
				for(int r2 = r1 + 1; r2 < numOfLines; r2++){
					double x3 = lines[r2][0], y3 = lines[r2][1], x4 = lines[r2][2], y4 = lines[r2][3];

					double[] pq = solve2x2(x1-x2, x4-x3, y1-y2, y4-y3, x4-x2, y4-y2);

					if(pq != null && (0 <= pq[0] && pq[0] <=1)  && (0 <= pq[1] && pq[1] <= 1)){
						segments+= 2;
						bySelf = false;
					}else if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)){
						segments+= 2;
						bySelf = false;
					}
				}

				if(bySelf){
					//segments+=1;
				} else{
					bySelf = true;
				}
			}

			System.out.println(segments);
			if(testcases > 1 && t != testcases){
				System.out.println("");
			}
		}
		
	}

	private static double[] solve2x2(double a, double b, double c, double d, double e, double f){
		//	([d -b] / determinant )		*	[e]
		//	([-c a]				  )		*	[f]

		double determinant = a * d - b * c;
		if(determinant == 0){return null;}

		double[] ans = new double[2];
		ans[0] = (d * e - b * f) / determinant; 
		ans[1] = (-c * e + a * f) / determinant;
		return ans;
	}
}