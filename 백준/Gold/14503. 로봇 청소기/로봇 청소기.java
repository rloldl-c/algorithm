/**
* @author 은비
* @since 2023-08-23
* @see https://www.acmicpc.net/problem/14503
* @performance
* @category #구현
* @note 
* 현재 칸이 청소 된 칸인지부터 판별 -> 청소되지 않았다면 청소(cnt+1)
* 1. 주위 4칸이 청소됐는지?
* true - 현재 방향으로 한 칸 후진할 수 있는지?
* 		true - 후진하고 1번부터 다시 반복
* 		false - 종료
* false - 반시계 방향으로 회전
* 		  앞 칸이 청소되지 않은 빈칸인지?
* 		  true - 전진하고 1번부터 다시 반복
* 		  false - 1번부터 다시 반복
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cnt;
	static int[][] room, deltas;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		// 					   0: 북   1: 동   2: 남    2: 서
		deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		room = new int[N][M];
		
		tokens = new StringTokenizer(input.readLine());
		int R = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());
		int d = Integer.parseInt(tokens.nextToken());
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				// 1은 벽, 0은 청소되지 않은 칸, -1 청소된 칸
				room[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		boolean isClear = true; // 주위 4칸이 모두 청소 되었는가
		// 청소기 초기 위치
		int r = R;
		int c = C;
		while(true) {
			isClear = true;
			// 현재 위치가 청소되지 않았다면 청소
			if(room[r][c] == 0) {
				cnt++;
				room[r][c] = -1;
			}
			
			for(int nd = 0; nd < 4; nd++) {
				int nr = r + deltas[nd][0];
				int nc = c + deltas[nd][1];
				
				// 주위 4칸에 청소되지 않은 칸이 있으면 false로 바꾸고 break
				if(room[nr][nc] == 0) {
					isClear = false;
					break;
				}
			}
			
			if(isClear) {
				// 현재 방향으로 후진할 수 있는지를 판단
				int nr = r - deltas[d][0];
				int nc = c - deltas[d][1];
				
				// 후진한 칸이 벽이면 종료
				if(room[nr][nc] == 1) {
					break;
				} else { // 후진할 수 있다면 후진
					r = nr;
					c = nc;
				}
			} else {
				// 반시계 방향 회전
				if(d == 0) {
					d = 3;
				} else {
					--d;
				}
				
				// 바꾼 방향으로 앞에 한 칸이 청소되지 않은 칸인지 판별
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				// 청소되지 않았다면 그 칸으로 이동
				if(room[nr][nc] == 0) {
					r = nr;
					c = nc;
				}
			}
		}
		
		System.out.println(cnt);
	}

}