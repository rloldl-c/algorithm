import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cnt;
	static int[][] map, deltas;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		deltas = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(!visited[r][c]) {
					if(dfs(r, c)) {
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static boolean dfs(int r, int c) {
		ArrayDeque<Pos> stack = new ArrayDeque<>();
		Deque<Pos> top = new ArrayDeque<>();
		stack.offerLast(new Pos(r, c, map[r][c]));
		top.offer(new Pos(r, c, map[r][c]));
		visited[r][c] = true;

		while(!stack.isEmpty()) {
			Pos now = stack.pollFirst();
			visited[r][c] = true;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				
				if(!isIn(nr, nc) || visited[nr][nc]) continue;
				
				if(now.h == map[nr][nc]) {
					top.offer(new Pos(nr, nc, map[nr][nc]));
					stack.offerFirst(new Pos(nr, nc, map[nr][nc]));
					visited[nr][nc] = true;
				}
			}
		}

		return isTop(top);
	}
	
	static boolean isTop(Deque<Pos> top) {
		while(!top.isEmpty()) {
			Pos now = top.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				
				if(!isIn(nr, nc)) continue;

				if(now.h < map[nr][nc]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
	static class Pos {
		int r;
		int c;
		int h;
		
		public Pos(int r, int c, int h) {
			super();
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
}