import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt(); //number of test cases

		for (int group = 0; group < t; group++){
			LinkedHashMap<String, Integer> websites = new LinkedHashMap<String, Integer>();
			String key = in.next();
			int value = in.nextInt();

			websites.put(key, value);

			for(int i = 1; i < 10; i++){
				key = in.next();
				value = in.nextInt();
				websites.put(key, value);
			}

			int max =  0;
			System.out.println("Case #" + (group + 1) + ":");

			for (Integer v: websites.values()){
				if (v > max){ max = v;}
			}

			for (String website: websites.keySet()){
				if(websites.get(website) == max){System.out.println(website);}
			}
		}
	}
}