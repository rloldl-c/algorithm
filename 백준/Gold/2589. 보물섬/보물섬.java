import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int L, W, ans;
	static int[][] deltas;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		L = Integer.parseInt(tokens.nextToken());
		W = Integer.parseInt(tokens.nextToken());
		map = new char[L][W];

		for(int r = 0; r < L; r++) {
			map[r] = input.readLine().toCharArray();
		}
		
		for(int r = 0; r < L; r++) {
			for(int c = 0; c < W; c++) {
				if(map[r][c] == 'L') {
					bfs(r, c);
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int sr, int sc) {
		boolean[][] visited = new boolean[L][W];
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(sr, sc, 0));
		visited[sr][sc] = true;
		int max = 0;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				int cnt = now.cnt;
				
				max = Math.max(cnt, max);
				
				if(nr < 0 || nr >= L || nc < 0 || nc >= W || visited[nr][nc] || map[nr][nc] == 'W') {
					continue;
				}
				
				visited[nr][nc] = true; 
				que.offer(new Pos(nr, nc, cnt+1));
			}
		}
		
		ans = Math.max(ans, max);
	}
	
	static class Pos {
		int r, c, cnt;

		public Pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}