import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		System.out.println("INTERSECTING LINES OUTPUT");

		int n = in.nextInt();

		for(int testCase = 1; testCase <= n; testCase++){
			//	p*(x1,y1) + (1-p*)(x2,y2) == q*(x3,y3) + (1-q)*(x4,y4)

			//	[x1-x2 x4-x3] [p] = [x4-x2]
			//	[y1-y2 y4-y3] [q] = [y4-y2]

			double x1 = in.nextDouble(), y1 = in.nextDouble(), x2 = in.nextDouble(), y2 = in.nextDouble(), x3 = in.nextDouble(), y3 = in.nextDouble(), x4 = in.nextDouble(), y4 = in.nextDouble();

			double[] pq = solve2x2(x1-x2, x4-x3, y1-y2, y4-y3, x4-x2, y4-y2);

			if(pq != null){
				double p = pq[0], x = p * x1 + (1 - p) * x2,  y = p * y1 + (1- p) * y2;
				System.out.println("POINT " + String.format("%.2f", x) + " " + String.format("%.2f", y));
			}

			else if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)){
				System.out.println("LINE");
			}else{
				System.out.println("NONE");
			}
		}

		System.out.println("END OF OUTPUT");
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