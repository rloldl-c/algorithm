import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			int k = Integer.parseInt(input.readLine());
			int n = Integer.parseInt(input.readLine());
			int[][] apart = new int[k+1][n+1];
			
			for(int c = 0; c < n; c++) {
				apart[0][c] = c + 1;
			}
			
			for(int r = 0; r <= k; r++) {
				apart[r][0] = 1;
			}
			
			for(int r = 1; r < k+1; r++) {
				for(int c = 1; c < n; c++) {
					apart[r][c] = apart[r-1][c] + apart[r][c-1];
				}
			}

			output.append(apart[k][n-1]).append("\n");
		}
		System.out.println(output);
	}
}
