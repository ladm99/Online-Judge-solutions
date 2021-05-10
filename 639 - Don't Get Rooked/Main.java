import java.util.*;

public class Main{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		while(true){
			int n = in.nextInt();
			if(n == 0){return;}

			char[][] board = new char[n][];
			for(int row = 0; row < n; row++){
				board[row] = in.next().toCharArray(); 
			}

			int[] count = new int[] {0};
			int[] max = new int[] {0};
			max[0] = legal(n, board, 0, 0, count, max);
			
			
			System.out.println(max[0]);
		}
	}

	public static boolean open(int n, char[][] board, int row, int col){
		for(int i = row - 1; i >= 0; i--){
			if(board[i][col] == 'X'){
				break;
			}else if(board[i][col] == 'R'){
				return false;
			}
		}

		for(int i = row + 1; i < n; i++){
			if(board[i][col] == 'X'){
				break;
			}else if(board[i][col] == 'R'){
				return false;
			}
		}

		for(int i = col - 1; i >= 0; i--){
			if(board[row][i] == 'X'){
				break;
			}else if(board[row][i] == 'R'){
				return false;
			}
		}

		for(int i = col + 1; i < n; i++){
			if(board[row][i] == 'X'){
				break;
			} else if(board[row][i] == 'R'){
				return false;
			}
		}

		return true;
	}

	public static int legal(int n, char[][] board, int row, int col, int[] count, int[] max){
		if(row == n-1 && col == n) {
			return max[0];
		}
		for(int r = 0; r < n; r++){
			for(int c = 0; c < n; c++){
				if(board[r][c] == '.' && open(n, board, r, c)){
					board[r][c] = 'R';
					count[0]++;
					
					if(count[0] > max[0]) {
						max[0] = count[0];
					}
					
					legal(n, board, r, c+1, count, max);
					
					count[0]--;
					board[r][c] = '.';
				}
			}

		}
		return max[0];

	}
}