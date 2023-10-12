import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		long [][] map = new long[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];
		
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				if(map[r][c] == 1) continue;
				
				// 가로
				dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][2];
				
				// 세로
				dp[r][c][1] += dp[r-1][c][1] + dp[r-1][c][2];
				
				// 대각
				if(map[r][c-1] != 1 && map[r-1][c] != 1) {
					dp[r][c][2] += dp[r-1][c-1][0] + dp[r-1][c-1][1] + dp[r-1][c-1][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}