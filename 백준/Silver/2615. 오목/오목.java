import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] board = new int[19][19];
		boolean flag = false;
		
		for(int r = 0; r < 19; r++) {
			tokens = new StringTokenizer(br.readLine());
			for(int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 0; r < 19; r++) {
			for(int c = 0; c < 19; c++) {
				if(board[r][c] != 0) {
					if(rowCheck(r, c, board, board[r][c]) || colCheck(r, c, board, board[r][c]) || crossCheck1(r, c, board, board[r][c]) || crossCheck2(r, c, board, board[r][c])) {
						output.append(board[r][c]).append("\n").append(r+1).append(" ").append(c+1);
						flag = true;
						break;
					}
				}
			}
			if(flag) {
				break;
			}
		}
		
		if(flag) {
			System.out.println(output);
		} else {
			System.out.println(0);
		}
	}
	
	public static boolean rowCheck(int r, int c, int[][] board, int color) {
		for(int i = 0; i < 5; i++) {
			if(c + i >= 19 || board[r][c+i] != color) {
				return false;
			}
		}
		if(c - 1 >= 0 && board[r][c-1] == color) {
			return false;
		}
		
		if(c + 5 < 19 && board[r][c+5] == color) {
			return false;
		}
		
		return true;
	}
	
	public static boolean colCheck(int r, int c, int[][] board, int color) {
		for(int i = 0; i < 5; i++) {
			if(r + i >= 19 || board[r+i][c] != color) {
				return false;
			}
		}
		
		if(r - 1 >= 0 && board[r-1][c] == color) {
			return false;
		}
		
		if(r + 5 < 19 && board[r+5][c] == color) {
			return false;
		}
		
		return true;
	}
	
	public static boolean crossCheck1(int r, int c, int[][] board, int color) {
		for(int i = 0; i < 5; i++) {
			if(r + i >= 19 || c + i >= 19 || board[r+i][c+i] != color) {
				return false;
			}
		}
		
		if(r - 1 >= 0 && c - 1 >= 0 && board[r-1][c-1] == color) {
			return false;
		}
		
		if(r + 5 < 19 && c + 5 < 19 && board[r+5][c+5] == color) {
			return false;
		}
		
		return true;
	}
	
	public static boolean crossCheck2(int r, int c, int[][] board, int color) {
		for(int i = 0; i < 5; i++) {
			if(r - i < 0 || c + i >= 19 || board[r-i][c+i] != color) {
				return false;
			}
		}
		if(r + 1 < 19 && c - 1 >= 0 && board[r+1][c-1] == color) {
			return false;
		}
		
		if(r - 5 >= 0 && c + 5 < 19 && board[r-5][c+5] == color) {
			return false;
		}
		
		return true;
	}
}

