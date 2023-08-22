/**
* @author 은비
* @since 2023-08-23
* @see 
* @performance
* @category #구현
* @note 
* 미세먼지는 한 번에 확산 -> 확산되는 총합을 다른 배열에서 계산한 후 원본 배열에 반영
*/

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, T;
	static int[][] map, topDeltas, bottomDeltas;
	static Pos[] air;

	public static void main(String[] args) throws IOException{
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		bottomDeltas = new int[][] {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
		topDeltas = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		map = new int[R][C];
		air = new Pos[2];
		
		for(int r = 0, idx = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == -1) {
					air[idx++] = new Pos(r, c);
				}
			}
		}

		for(int t = 0; t < T; t++) {
			spreadDust();
			moveDust();
		}
		
		int ans = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					ans += map[r][c];
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static void spreadDust() {
		int[][] tmp = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					int cnt = 0; // 확산된 방향의 개수
					for(int d = 0; d < topDeltas.length; d++) {
						int nr = r + topDeltas[d][0];
						int nc = c + topDeltas[d][1];
						
						if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
							tmp[nr][nc] += map[r][c] / 5;
							cnt++;
						}
					}
					
					tmp[r][c] += -map[r][c] / 5 * cnt;
				}
			}
		}
		
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] != -1) {					
					map[r][c] += tmp[r][c];
				}
			}
		}
		
		
	}
	
	static void moveDust() {
		// 위쪽 바람 순환
		int r = air[0].r;
		int c = air[0].c;
		
		// 아래
		int bottomTmp = map[r][C-1];
		for(int nc = C-1; nc >= c+1; nc--) {
			if(map[r][nc-1] > 0) {
				map[r][nc] = map[r][nc-1];
			} else {
				map[r][nc] = 0;
			}
		}
		
		// 오른쪽
		int rightTmp = map[0][C-1];
		for(int nr = 0; nr < r; nr++) {
			map[nr][C-1] = map[nr+1][C-1];
		}
		map[r-1][C-1] = bottomTmp;
		
		// 위
		int topTmp = map[0][0];
		for(int nc = 0; nc < C-1; nc++) {
			map[0][nc] = map[0][nc+1];
		}
		map[0][C-2] = rightTmp;
		
		// 왼쪽
		
		for(int nr = r-1; nr >= 1; nr--) {
			map[nr][0] = map[nr-1][0];
		}
		map[1][0] = topTmp;
		
		// 아래 바람 순환
		r = air[1].r;
		c = air[1].c;
		
		// 위
		topTmp = map[r][C-1];
		for(int nc = C-1; nc >= c+1; nc--) {
			if(map[r][nc-1] > 0) {				
				map[r][nc] = map[r][nc-1];
			} else {
				map[r][nc] = 0;
			}
		}
		
		// 오른쪽
		rightTmp = map[R-1][C-1];
		for(int nr = R-1; nr >= r+1; nr--) {
			map[nr][C-1] = map[nr-1][C-1];
		}
		map[r+1][C-1] = topTmp;
		
		// 아래
		bottomTmp = map[R-1][0];
		for(int nc = 0; nc < C-1; nc++) {
			map[R-1][nc] = map[R-1][nc+1];
		}
		map[R-1][C-2] = rightTmp;
		
		// 왼쪽
		for(int nr = r+1; nr < R-1; nr++) {
			map[nr][0] = map[nr+1][0];
		}
		map[R-2][0] = bottomTmp;
	}
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}