import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[][] map = new int[N+1][M+1];
		int[][] dp = new int[N+1][M+1];
		
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 1; c <= M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp[1][1] = map[1][1];
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				dp[r][c] = map[r][c] + Math.max(Math.max(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1]);
			}
		}
		
		System.out.println(dp[N][M]);
	}

}