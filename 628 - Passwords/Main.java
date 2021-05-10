import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			if(!in.hasNext()){
				break;
			}
			int n = Integer.parseInt(in.nextLine());

			String[] dict = new String[n];
			for(int i = 0; i < n; i++){
				dict[i] = in.nextLine().trim();
			}

			int m = Integer.parseInt(in.nextLine());

			String[] rules = new String[m];

				for(int i = 0; i < m; i++){
					rules[i] = in.nextLine();
				}
				
			System.out.println("--");
			String word = "";
			for(int i = 0; i < m; i++){
				passwords(0, dict, rules[i], word);
			}
		}
	}

	public static void passwords(int index, String[] dict, String rule, String word){
		if(index == rule.length()){
			System.out.println(word);
			return;
		}

		if(rule.charAt(index) == '0'){
			for(int num = 0; num < 10; num++){
				passwords(index + 1, dict, rule, word + num);
			}


		}else if(rule.charAt(index) == '#'){
			for(int i = 0; i < dict.length; i++){
				passwords(index + 1, dict, rule, word + dict[i]);
			}
		}
		
	}
}