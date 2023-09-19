import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, time, ans, cheese;
	static int[][] map, deltas;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				if(map[r][c] == 1) cheese++;
			}
		}
		
		while(cheese != 0) {
			visited = new boolean[N][M];
			time++;
			ans = cheese;
			bfs();
		}
		
		System.out.println(time);
		System.out.println(ans);
	}
	
	static void bfs() {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 0));
		visited[0][0] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}
				
				visited[nr][nc] = true;
				if(map[nr][nc] == 0) {
					que.offer(new Pos(nr, nc));
				} else {
					cheese--;
					map[nr][nc] = 0;
				}
			}
		}
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