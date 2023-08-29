import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
