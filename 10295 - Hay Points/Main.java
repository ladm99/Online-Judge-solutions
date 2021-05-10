import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int m = in.nextInt(), n = in.nextInt();

		HashMap<String, Integer> map = new HashMap<>();

		for(int i = 0; i < m; i++){
			map.put(in.next(), in.nextInt());
		} 

		for(int i = 0; i < n; i++){
			int salary = 0;

			for(String word = in.next(); word.charAt(0) != '.'; word = in.next()){
				Integer value = map.get(word);
				if(value != null){
					salary+= value;
				}
			}

			System.out.println(salary);
		}
	}
}