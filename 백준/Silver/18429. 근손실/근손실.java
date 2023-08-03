/**
 * @author 은비
 * @since 2023-08-03
 * @see https://www.acmicpc.net/problem/18429
 * @performance
 * @category #순열
 * @note
 * 가지고 있는 운동 키트로 운동할 수 있는 순서 전부 구하기
 * -> 중복 X, 순서 의미 O
 * 구한 순서로 중량이 500보다 작아지는 구간이 있는지 탐색
 * 없으면 ans + 1
 * 작아지는 구간이 있으면  return
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, kit[];
	static int ans = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		tokens = new StringTokenizer(input.readLine());
		kit = new int[N];
		
		for(int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(tokens.nextToken());
		}
		
		makeCombi(0, new int[N], new boolean[N]);
		
		System.out.println(ans);
	}
	
	static void makeCombi(int n, int[] order, boolean[] visited) {
		if(n == N) {
			if(calWeight(order)) {
				ans++;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				order[n] = i+1;
				makeCombi(n+1, order, visited);
				visited[i] = false;
			}
		}
	}
	
	static boolean calWeight(int[] order) {
		int now = 500;
		
		for(int i: order) {
			now += kit[i-1];
			now -= K;
			
			if(now < 500) {
				return false;
			}
		}
		
		return true;
	}
}
