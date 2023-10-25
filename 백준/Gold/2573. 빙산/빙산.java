import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[][] map, deltas;

	public static void main(String[] args) throws IOException {
		deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
        
		int cnt = 0;
		
		cnt = countIceberg();
		
		if(cnt >= 2) {
			System.out.println(0);
		} else {
			int time = 1;
			while(true) {
				cnt = 0;
				
				shrink();

				cnt = countIceberg();

				if(cnt >= 2) {
					System.out.println(time);
					break;
				}
				
				if(noIceberg()) {
					System.out.println(0);
					break;
				}
				
				time++;
				
				
			}
		}
	}
	
	static boolean noIceberg() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] != 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static int countIceberg() {
		boolean[][] visited = new boolean[N][M];
		int cnt = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] != 0 && !visited[r][c]) {
					cnt++;
					bfs(r, c, visited);
				}
			}
		}
		
		return cnt;
	}
	
	static void shrink() {
		int[][] tmp = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] != 0) {
					int cnt = 0;
					
					for(int d = 0; d < deltas.length; d++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];
						
						if(isIn(nr, nc) && map[nr][nc] == 0) {
							cnt++;
						}
					}
					
					tmp[r][c] = cnt;
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				map[r][c] -= tmp[r][c];
				
				if(map[r][c] < 0) {
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void bfs(int r, int c, boolean[][] visited) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(r, c));
		visited[r][c] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}
				
				visited[nr][nc] = true;
				que.offer(new Pos(nr, nc));
			}
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
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