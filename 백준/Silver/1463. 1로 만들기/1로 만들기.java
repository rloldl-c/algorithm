import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] dp = new int[N+1];
		// 최소값 찾기 -> dp 테이블을 최대값으로 초기화
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// 1에서 1로 만드는 최소 횟수 0
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			
		}

		System.out.println(dp[N]);
	}

}