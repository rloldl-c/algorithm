/**
 * @author 은비
 * @since 2023-08-02
 * @see
 * @performance
 * @category #배열
 * @note
 * N*N 배열 하나 만들고 1씩 증가시키면서 배열 채우기
 * 방향 전환을 위한 deltas 만들기
 * 우-하-좌-상 순서로 바뀌니까 deltas={{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
 * N 범위를 넘어가거나 이미 값이 채워졌으면 방향 바꿔주기(deltas의 인덱스 증가시키기)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {		
			int N = Integer.parseInt(input.readLine());
			int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
			int[][] arr = new int[N][N];
			int val = 1;
			int nr = 0, nc = 0, r = 0, c = -1, d = 0;
			
			while(true) {
				if(val == N*N+1) {
					break;
				}
				
				nr = r + deltas[d][0];
				nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
					r = nr;
					c = nc;
					arr[r][c] = val;
					val++;
				} else {
					if(d == 3) {
						d = 0;
					} else {
						d++;					
					}
				}
			}
			
			output.append("#").append(t+1).append("\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					output.append(arr[i][j]).append(" ");
				}
				
				output.append("\n");
			}
		}
		
		System.out.println(output);
		
	}

}
