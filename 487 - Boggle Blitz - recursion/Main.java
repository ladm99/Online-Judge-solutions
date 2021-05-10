import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int numTestCases = in.nextInt();
		for(int testCase = 1; testCase <= numTestCases; testCase++){
			if(testCase > 1){System.out.println();}

			int n = in.nextInt();
			char[][] board = new char[n][];
			for(int row = 0; row < n; row++){
				board[row] = in.next().toCharArray();
			}

			HashSet<String> words = new HashSet<>();

			for(int row = 0; row < n; row++){
				for(int col = 0; col < n; col++){
					find(n, board, row,col, String.valueOf(board[row][col]), words);
				}
			}

			String[] wordsArray = words.toArray(new String[0]);

			Arrays.sort(wordsArray, new MyComparator());

			for(String word : wordsArray){
				System.out.println(word);
			}
		}
	}

	private static void find(int n, char[][] board, int row, int col, String soFar, HashSet<String> words){
		if(soFar.length() >= 3){words.add(soFar);}

		for(int r = Math.max(row - 1, 0); r <= Math.min(row + 1, n - 1); r++){
			for(int c = Math.max(col - 1, 0); c <= Math.min(col + 1, n - 1); c++){
				if(board[r][c] > board[row][col]){
					find(n, board, r, c, soFar + board[r][c], words);
				}
			}
		}
	}

	static class MyComparator implements Comparator<String>{
		public int compare(String a, String b){
			if(a.length() < b.length()){return -1;}
			else if(a.length() > b.length()){return 1;}
			return a.compareTo(b);
		}
	}
}