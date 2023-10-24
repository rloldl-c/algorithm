import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[][] deltas;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		visited = new boolean[1<<6][N][M];
		Pos start = null;
		
		for(int r = 0; r < N; r++) {
			map[r] = input.readLine().toCharArray();
			for(int c = 0; c < M; c++) {
				if(map[r][c] == '0') {
					start = new Pos(r, c, 0, 0);
				}
			}
		}
		
		bfs(start);
	}
	
	static void bfs(Pos start) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(start);
		visited[start.key][start.r][start.c] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				int cnt = now.cnt;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[now.key][nr][nc] || map[nr][nc] == '#') {
					continue;
				}

				if(map[nr][nc] == '1') {
					System.out.println(cnt+1);
					return;
				}
				
				// 다음 칸에 열쇠가 있으면 줍기
				if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
					int key = now.key | (1 << (map[nr][nc] - 'a'));
					visited[key][nr][nc] = true;
					que.offer(new Pos(nr, nc, key, cnt+1));
					
					// 다음 칸이 문이고, 현재 그 문의 열쇠가 있으면
				} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
					boolean flag = (now.key & (1 << (map[nr][nc] - 'A'))) != 0;
					
					if(flag) {
						visited[now.key][nr][nc] = true;
						que.offer(new Pos(nr, nc, now.key, cnt+1));
					}
				} else {
					visited[now.key][nr][nc] = true;
					que.offer(new Pos(nr, nc, now.key, cnt+1));
				}
			}
		}
		
		System.out.println(-1);
	}
	
	static class Pos {
		int r, c, key, cnt;

		public Pos(int r, int c, int key, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.key = key;
			this.cnt = cnt;
		}
	}
}