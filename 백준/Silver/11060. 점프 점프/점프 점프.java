import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] nums = new int[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		tokens = new StringTokenizer(input.readLine());
		for(int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		dp[1] = 0;
		
		for(int i = 1; i <= N; i++) {
			if(dp[i] != Integer.MAX_VALUE && nums[i] != 0) {
				for(int j = 1; j <= nums[i]; j++) {
					if(i+j > N) {
						continue;
					}
					
					dp[i+j] = Math.min(dp[i]+1, dp[i+j]);						
				}
				
			}
			
		}
		
		System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
	}
}