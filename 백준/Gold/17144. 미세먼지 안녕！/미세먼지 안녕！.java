import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, T;
	static int[][] map, deltas;
	static ArrayList<Pos> air;

	public static void main(String[] args) throws IOException {
		deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		air = new ArrayList<>();
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		
		map = new int[R][C];
		for(int r = 0; r < R; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] == -1) {
					air.add(new Pos(r, c));
				}
			}
		}
		
		for(int t = 0; t < T; t++) {			
			spreadDust();
			topAir();
			bottomAir();
		}
		
		countDust();
		
	}
	
	static void countDust() {
		int cnt = 0;
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] > 0) {
					cnt += map[r][c];
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	// 위쪽 공기청정기
	static void topAir() {
		int top = map[0][0];
		int right = map[0][C-1];
		int bottom = map[air.get(0).r][C-1];
		int left = 0;
		
		// 상
		for(int c = 0; c < C-1; c++) {
			map[0][c] = map[0][c+1];
		}
		map[0][C-1] = right;
		
		// 좌
		for(int r = air.get(0).r-1; r > 0; r--) {
			map[r][0] = map[r-1][0];
		}
		map[1][0] = top;
		
		// 하
		for(int c = C-1; c > 0; c--) {
			map[air.get(0).r][c] = map[air.get(0).r][c-1];
		}
		map[air.get(0).r][1] = left; 
		
		// 우
		for(int r = 0; r < air.get(0).r; r++) {
			map[r][C-1] = map[r+1][C-1];
		}
		map[air.get(0).r-1][C-1] = bottom;
	}
	
	// 아래쪽 공기청정기
	static void bottomAir() {
		int top = map[air.get(1).r][C-1];
		int right = map[R-2][C-1];
		int bottom = map[R-1][1];
		int left = 0;
		
		// 상
		for(int c = C-1; c > 0; c--) {
			map[air.get(1).r][c] = map[air.get(1).r][c-1];
		}
		map[air.get(1).r][1] = left;
		
		// 좌
		for(int r = air.get(1).r + 1; r < R-1; r++) {
			map[r][0] = map[r+1][0];
		}
		map[R-1][0] = bottom;
		
		// 하
		for(int c = 0; c < C-1; c++) {
			map[R-1][c] = map[R-1][c+1];
		}
		map[R-1][C-1] = right;
		
//		// 우
		for(int r = R-1; r > air.get(1).r; r--) {
			map[r][C-1] = map[r-1][C-1];
		}
		map[air.get(1).r+1][C-1] = top;
		
	}
	
	static void spreadDust() {
		int[][] dust = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] != 0) {
					int cnt = 0; // 확산되는 칸
					int amount = map[r][c] / 5;
					
					for(int d = 0; d < deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(!isIn(nr, nc) || map[nr][nc] == -1) {
							continue;
						}
						
						dust[nr][nc] += amount;
						cnt++;
					}
					
					dust[r][c] -= amount * cnt;
				}
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				map[r][c] += dust[r][c];
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
	}
}