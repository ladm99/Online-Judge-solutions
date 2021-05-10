import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			if(!in.hasNextLine()){return;}

			String line = in.nextLine();
			if(line.equals("___________") && in.hasNextLine()){
				line = in.nextLine(); //skips the ___________
			}else if(line.equals("___________") && !in.hasNextLine()) {return;}
			int num = 0;

			line = line.replace("|","");
			line = line.replace(".","");
			line = line.replaceAll("o","1");
			line = line.replaceAll(" ","0");
			
			String reverseLine = ""; //this is so that index 0 of the line and bits of num are the same
			for(int i = line.length() - 1; i >= 0; i--) {
				reverseLine += line.charAt(i);
			}
			for(int i = 0; i < reverseLine.length(); i++){
				if(reverseLine.charAt(i) == '1'){
					num |= (1 << i);
				}
			}
			System.out.print((char)num);

		}
	}
}