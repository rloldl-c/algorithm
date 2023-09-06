import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int A = Integer.parseInt(input.readLine());
		int[] nums = new int[A];
		int[] dp = new int[A];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < A; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}

		int max = 0;
		for(int i = 0; i < A; i++) {
			dp[i] = 1;
			
			int idx = 0;
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && dp[i] <= dp[j]) {
					dp[i] = dp[j]+1;
				}
			}
			
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}