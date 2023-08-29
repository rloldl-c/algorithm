import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[][] rgb = new int[N][3];
		int[][] dp = new int[N][3];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 3; c++) {
				rgb[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		
		for(int c = 0; c < 3; c++) {
			dp[0][c] = rgb[0][c];
		}
		
		for(int r = 1; r < N; r++) {			
			dp[r][0] = rgb[r][0] + Math.min(dp[r-1][1], dp[r-1][2]);
			dp[r][1] = rgb[r][1] + Math.min(dp[r-1][0], dp[r-1][2]);
			dp[r][2] = rgb[r][2] + Math.min(dp[r-1][1], dp[r-1][0]);
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}

}