import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		for(int testCase = 1; ;){
			int nc = in.nextInt();
			if(nc == 0){return;}

			HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
			HashSet<Integer> connections = new HashSet<>();
			for(int i = 0; i < nc; i++){
				int u = in.nextInt(), v = in.nextInt();

				if(!adj.containsKey(u)){adj.put(u, new ArrayList<Integer>());}
				if(!adj.containsKey(v)){adj.put(v, new ArrayList<Integer>());}

				ArrayList<Integer> uAdj = adj.get(u), vAdj = adj.get(v);

				uAdj.add(v);
				vAdj.add(u);

				connections.add(v);
				connections.add(u);
			}
			while(true){
				int s = in.nextInt(), ttl = in.nextInt();

				if(s == 0 && ttl == 0){
					break;
				}

				HashSet<Integer> disc = new HashSet<>();
				disc.add(s);

				int[] queue = new int[2 * nc + 1];
				queue[0] = s;
				int head = 0, tail = 1;

				HashMap<Integer, Integer> prev = new HashMap<>();

				int count = 1;

				while(head < tail){
					int u = queue[head++];
					if(!connections.contains(s)) {
						break;
					}else {
						for(int v : adj.get(u)){
							if(!disc.contains(v)){
								disc.add(v);
								queue[tail++] = v;
								prev.put(v, u);
							}
						}
					}

					count++;
				}
				int noReach = 0;

				for(Integer conn : connections){
					int v = conn;
					int dist = 0;
					while(v != s){
						if(!prev.containsKey(v)) {
							noReach++;
							break;
						}else {
							int u = prev.get(v);
							v = u;
							//if(v == s) {break;}
							dist++;
						}
					}
					if(dist > ttl){
						noReach++;
					}
				}
				System.out.println("Case " + testCase++ + ": " + noReach + " nodes not reachable from node " + s + " with TTL = " + ttl + ".");
			}
		}
	}
}