import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int e = in.nextInt();
		int[][] adj = new int[e][];

		for(int i = 0; i < e; i++){
			int n = in.nextInt();
			int[] temp = new int[n];

			for(int x = 0; x < n; x++){
				temp[x] = in.nextInt();
			}

			adj[i] = temp;
		}
		while(in.hasNextInt()){
			int t = in.nextInt();
			for(int testCase = 1; testCase <= t; testCase++){
				int start = in.nextInt();
				boolean[] disc = new boolean[e];				
				ArrayList<Integer> queue = new ArrayList<>();
				HashMap<Integer,Integer> prev = new HashMap<>();
				
				ArrayList<Integer> current = new ArrayList<>();
				ArrayList<Integer> next = new ArrayList<>();
				disc[start] = true;
				current.add(start);



				int m = 0;
				int d = 1;
				int count = 0;
				while(current.size() > 0){
					int u = current.remove(0);

					for(int v : adj[u]){
						if(!disc[v]){
							disc[v] = true;
							//queue.add(v);
							next.add(v);
							prev.put(v,u);

						}
					}
					
					if(next.size() > m) {
						m = next.size();
						d = count+1;
					}
					if(current.size() == 0){
						for(int x : next) {
							current.add(x);
						}
						next.clear();
						count++;
						}
					else if(current.size() != 0){
						continue;
					}
					
				}
				if(m == 0 && d == 1) {
					System.out.println(0);
				}else {
					System.out.println(m + " " + d);
				}
			}

		}
	}
}