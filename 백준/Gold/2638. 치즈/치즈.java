import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cheese;
	static int[][] map, deltas;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		cheese = 0;
		int time = 0;
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] == 1) {
					cheese++;
				}
			}
		}
		
		while(cheese > 0) {
			bfs();
			time++;
		}
		
		System.out.println(time);
	}
	
	static void bfs() {
		Deque<Pos> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] copy = air();
		
		que.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(!isIn(nr, nc) || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				if(copy[nr][nc] == 1) {
					if(check(nr, nc, copy)) {
						map[nr][nc] = 0;
						copy[nr][nc] = 0;
						cheese--;
					}
				} else if(copy[nr][nc] == 2) {
					que.offer(new Pos(nr, nc));
				}
			}
		}
	}
	
	static int[][] air() {
		Deque<Pos> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		que.offer(new Pos(0, 0));
		visited[0][0] = true;
		int[][] copy = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				copy[r][c] = map[r][c];
			}
		}
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(!isIn(nr, nc) || visited[nr][nc]) {
					continue;
				}

				if(copy[nr][nc] == 0) {
					copy[nr][nc] = 2;
					visited[nr][nc] = true;
					que.offer(new Pos(nr, nc));
				}
			}
		}

        return copy;
	}
	
	static boolean check(int r, int c, int[][] copy) {
		int cnt = 0;
		
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(copy[nr][nc] == 2) {
				cnt++;
			}
		}
		
		return cnt >= 2;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
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