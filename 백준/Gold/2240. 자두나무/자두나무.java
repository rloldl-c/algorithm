/**
* @author 은비
* @since 2023-10-16
* @see https://www.acmicpc.net/problem/2240
* @performance
* @category #dp
* @note 
* 받을 수 있는 자두의 개수에 영향을 주는 요인들
* 1. 현재 내 위치 n
* 2. 현재 시간 T
* 3. 이동 횟수 W
* dp[n][T][W] = T번째 나무가 떨어졌을 때, 현재 W만큼 이동했고 n에 있을 때 얻을 수 있는 최대 자두의 개수
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int T = Integer.parseInt(tokens.nextToken());
		int W = Integer.parseInt(tokens.nextToken());
		int[][][] dp = new int[3][T+1][W+1];
		
		int now = Integer.parseInt(input.readLine());
		
		// 맨 처음 떨어지는 자두 위치가 1이면 
		if(now == 1) {
			dp[1][1][0] = 1; // 현재 한 번도 움직이지 않고 1번에 있고, 자두를 하나 먹음
			dp[2][1][1] = 0; // 현재 한 번 움직여서 2번에 있고, 자두를 하나도 먹지 못함
		} else { // 자두가 2에 떨어지면 그 반대
			dp[1][1][0] = 0;
			dp[2][1][1] = 1;
		}
				
		for(int t = 2; t < T+1; t++) {
			now = Integer.parseInt(input.readLine());
			
			if(now == 1) {
				// 한 번도 움직이지 않았을 때
				dp[1][t][0] = dp[1][t-1][0] + 1;
				dp[2][t][0] = dp[2][t-1][0];
				
				// 한 번도 움직이지 않았을 때를 기준으로 움직여가며 최대값 갱신
				for(int w = 1; w < W+1; w++) {
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]) + 1;
					dp[2][t][w] = Math.max(dp[1][t-1][w-1], dp[2][t-1][w]);
				}
			} else {
				dp[1][t][0] = dp[1][t-1][0];
				dp[2][t][0] = dp[2][t-1][0] + 1;
				
				for(int w = 1; w < W+1; w++) {
					dp[1][t][w] = Math.max(dp[1][t-1][w], dp[2][t-1][w-1]);
					dp[2][t][w] = Math.max(dp[1][t-1][w-1], dp[2][t-1][w]) + 1;
				}
			}
		}
		
		int ans = 0;
		
		// W를 다 움직였을 때가 최대값이 아닐 수 있음..?
		for(int w = 0; w < W+1; w++) {
			ans = Math.max(ans, Math.max(dp[1][T][w], dp[2][T][w]));
		}
		
		System.out.println(ans);
	
	}
}