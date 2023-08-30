import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			int[][] dp = new int[M+1][N+1];

			for(int i = 0; i <= M; i++) {
				for(int j = 0, end = Math.min(i, N); j <= end; j++) {
					if(j == 0 || i == j) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j] + dp[i-1][j-1];					
					}
				}
			}
			
			output.append(dp[M][N] + "\n");
		}
		
		System.out.println(output);
	}

}