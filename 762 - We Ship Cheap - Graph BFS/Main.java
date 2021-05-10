import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for (int testCase = 1; in.hasNext(); testCase++) {
			if(testCase > 1){System.out.println();}

			int m = in.nextInt();

			HashMap<String, ArrayList<String>> adj = new HashMap<>();
			for(int i = 0; i < m; i++){
				String u = in.next(), v = in.next();

				if(!adj.containsKey(u)){adj.put(u, new ArrayList<String>());}
				if(!adj.containsKey(v)){adj.put(v, new ArrayList<String>());}
				ArrayList<String> uAdj = adj.get(u), vAdj = adj.get(v);

				uAdj.add(v);
				vAdj.add(u);
			}
			
			String s = in.next(), t = in.next();

			if(s.equals(t)){
				System.out.println();
				continue;
			} else if(!adj.containsKey(s)){
				System.out.println("No route");
				continue;
			}

			HashSet<String> disc = new HashSet<>();
			disc.add(s);

			String[] queue = new String[2 * m + 1];
			queue[0] = s;
			int head = 0, tail = 1;

			HashMap<String, String> prev = new HashMap<>();

			boolean success = false;
			while(!success && head < tail){
				String u = queue[head++];
				for(String v : adj.get(u)){
					if(!disc.contains(v)){
						disc.add(v);
						queue[tail++] = v;
						prev.put(v, u);

						if(v.equals(t)){
							success = true;
							break;
						}
					}
				}

			}
			if(success){
				String out = "";
				String v = t; 
				while(!v.equals(s)){
					String u = prev.get(v);
					out = u + " " + v + "\n" + out;
					v = u;
				}
				System.out.println(out.trim());
			} else{
				System.out.println("No route");
			}
		}
	}
}