import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ans;
	static int[][] map, deltas;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		deltas = new int[][] {{0, 1}, {1, 0}, {1, 1}};
		// 0: 가로, 1: 세로, 2: 대각	
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dfs(0, 0, new Pos(0, 1));
		
		System.out.println(ans);
	}
	
	static void dfs(int depth, int dir, Pos end) {
		if(end.r == N-1 && end.c == N-1) {
			ans++;
			return;
		}
		
		int r = end.r;
		int c = end.c;
		boolean flag = true;
		
		// 가로
		if(dir == 0) {
			for(int d = 0; d < 3; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];	
				
				if(isIn(nr, nc) && d == 0) {
					if(map[nr][nc] != 1) {
						dfs(depth+1, 0, new Pos(nr, nc));
					}
				}
				
				if(isIn(nr, nc)) {
					if(map[nr][nc] == 1) {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
			
			if(flag) {
				dfs(depth+1, 2, new Pos(r+1, c+1));
			}
		}
		
		// 세로
		if(dir == 1) {
			for(int d = 0; d < 3; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];	
				
				if(isIn(nr, nc) && d == 1) {
					if(map[nr][nc] != 1) {
						dfs(depth+1, 1, new Pos(nr, nc));
					}
				}
				
				if(isIn(nr, nc)) {
					if(map[nr][nc] == 1) {
						flag = false;
					}
				} else {
					flag = false;
				}
			}
			
			if(flag) {				
				dfs(depth+1, 2, new Pos(r+1, c+1));
			}
		}
		
		// 대각
		if(dir == 2) {
			for(int d = 0; d < 3; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];	
				
				if(isIn(nr, nc) && d != 2) {
					if(map[nr][nc] != 1) {
						dfs(depth+1, d, new Pos(nr, nc));
					}
				}
				
				if(isIn(nr, nc)) {
					if(map[nr][nc] == 1) {
						flag = false;
					} 
				} else {
					flag = false;
				}
			
			}

			if(flag) {
				dfs(depth+1, 2, new Pos(r+1, c+1));
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}