/**
 * @author 은비
 * @since 2023-08-03
 * @see https://www.acmicpc.net/problem/2961
 * @performance
 * @category #
 * @note
 * N개의 재료로 만들 수 있는 모든 조합을 만들고 그 조합 중에서 차이가 젤 적은 조합 찾기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, food[][], answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		food = new int[N][2];
		answer = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < 2; j++) {
				food[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		makeSubSet(0, new boolean[N]);
		
		System.out.println(answer);
	}

	static void makeSubSet(int n, boolean[] choose) {
		if (n == N) {
			calDiff(choose);
			return;
		}
		
		choose[n] = true;
		makeSubSet(n+1, choose);
		choose[n] = false;
		makeSubSet(n+1, choose);
	}
	
	static void calDiff(boolean[] choose) {
		int sour = 1;
		int bitter = 0;
		for(int i = 0; i < choose.length; i++) {
			if(choose[i]) {
				sour *= food[i][0];
				bitter += food[i][1];
			}
		}
		
		if(sour == 1 && bitter == 0) {
			return;
		}
		
		answer = Math.min(answer, Math.abs(sour - bitter));
		return;
	}
}
