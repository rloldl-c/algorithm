import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[][] nums = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < i+1; j++) {
				nums[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dp[0][0] = nums[0][0];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j == 0) {
					dp[i][j] = nums[i][j] + dp[i-1][j];
				} else  {
					dp[i][j] = nums[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(ans, dp[N-1][i]);
		}
		
		System.out.println(ans);
	}
}