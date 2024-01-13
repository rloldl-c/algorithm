/*
 * 1개: p[1] = dp[1]
 * 2개: dp[1] + p[1] or p[2] = dp[2]
 * 3개: dp[2] + p[1] or dp[1] + p[2] or p[3] = dp[3]
 * N개: dp[N-1] + p[1] or dp[N-2] + p[2] or ... or p[N] = dp[N]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int[] cards = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 1; i <= N; i++) {
			cards[i] = Integer.parseInt(tokens.nextToken()); 
		}
		
		int[] dp = new int[N+1];
		dp[1] = cards[1];
		
		for(int i = 2; i <= N; i++) {
			// i개 짜리 카드팩의 가격을 최대 가격으로 일단 지정
			dp[i] = cards[i];
			for(int j = 1; j < i; j++) {
				dp[i] = Integer.max(dp[i], dp[j] + cards[i-j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}