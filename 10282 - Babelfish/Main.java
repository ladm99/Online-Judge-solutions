import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
			HashMap<String, String> map = new HashMap<>();
			boolean space = false;

		while(true){
			if(!in.hasNextLine()){return;}
			String line = in.nextLine();
			
			if(line.equals("")){
				space = true;
				line = in.nextLine();
			}
			if(space){

				String out = map.get(line);
				if(out == null){
					System.out.println("eh");
				} else{
					System.out.println(out);
				}

			}else{
				String[] split = line.split(" ");
				map.put(split[1],split[0]);
			}

			
		}
	}
}