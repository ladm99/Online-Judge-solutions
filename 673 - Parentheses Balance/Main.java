import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		in.nextLine();

		for(int testCase = 1; testCase <= n; testCase++){
			String s = in.nextLine();

			Stack<Character> stack = new Stack<>();

			boolean bad = false;
			for(int i = 0; i < s.length(); i++){
				char cur = s.charAt(i);

				if(cur == '(' || cur == '['){
					stack.push(cur);
				}else if(stack.empty() || (stack.peek() == '(' && cur == ']') || (stack.peek() == '[' && cur == ')')){
					bad = true;
					break;
				}else {
					stack.pop();
				}
			}

			if(!stack.empty()){bad = true;}

			if(bad){System.out.println("No");}
			else {System.out.println("Yes");}
		}		
	}
}