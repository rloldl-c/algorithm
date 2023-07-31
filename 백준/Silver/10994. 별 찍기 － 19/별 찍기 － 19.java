import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static int max;
	static String[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		max = (N - 1) * 4 + 1;
		board = new String[max][max];
		
		star(0, max-1, N, board);
		
		for(int r = 0; r < max; r++) {
			for(int c = 0; c < max; c++) {
				if(board[r][c] != null) {					
					output.append(board[r][c]);
				} else {
					output.append(" ");
				}
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
		
	}
	
	public static void star(int start, int end, int N, String[][] board) {
		if(N == 1) {
			board[max/2][max/2] = "*";
			return;
		}

		for(int i = start; i <= end; i++) {
			board[i][end] = "*";
			board[start][i] = "*";
			board[i][max-end-1] = "*";
			board[max-start-1][i] = "*";
		}		
		
		star(start+2,  end-2, N - 1, board);
	}

}
