import java.util.*;
import java.math.BigInteger;
public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(in.hasNext()){
			ArrayList<Integer> nums = new ArrayList<>();
			int n = 0;
			while(n != -999999){
				n = in.nextInt();
				if(n != -999999){
					nums.add(n);
				}
			}

			BigInteger max = new BigInteger("-999999");
			
			for(int low = 0; low < nums.size(); low++){
				for(int high = low; high < nums.size(); high++){
					BigInteger product = new BigInteger("1");

					for(int i = low; i <= high; i++){
						product = product.multiply(BigInteger.valueOf(nums.get(i)));
					}
					if(product.compareTo(max) > 0){
						max = product;
					}
				}

			}

			System.out.println(max);

		}
	}
}
