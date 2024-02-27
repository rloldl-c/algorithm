import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		
		int[] value = new int[N+1];
		int[] weight = new int[N+1];
		int[][] dp = new int[K+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			tokens = new StringTokenizer(input.readLine());
			weight[i] = Integer.parseInt(tokens.nextToken());
			value[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				if(i >= weight[j]) {
					dp[i][j] = Integer.max(dp[i][j-1], dp[i - weight[j]][j-1] + value[j]);
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		
		System.out.println(dp[K][N]);
	}
}