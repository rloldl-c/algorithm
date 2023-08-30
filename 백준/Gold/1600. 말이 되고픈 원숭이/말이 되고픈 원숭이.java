/**
 * @author 은비
 * @since 2023-08-31
 * @see https://www.acmicpc.net/problem/1600
 * @performance 
 * @category #BFS
 * @note
 * 말의 방법으로 이동하는 방법(8방)과 걸어서 이동하는 방법(4방)이 다르기 때문에 이미 탐색한 점이라도 다른 방법으로 접근할 수 있음
 * (똑같은 위치를 걸어서 4번만에 갔을 수도, 말처럼 뛰어서 2번만에 갔을 수도, 둘 모두를 써서 3번 만에 갔을 수도 있음)
 * 이미 갔던 곳이라도 어떻게 이동했냐에 따라 이동 횟수가 달라지기 때문에 K에 따라 이동 횟수를 모두 기록해줘야 함
 * -> visited를 3차원으로 정의해서 위치와 그 위치에 도달하기까지 사용한 K의 횟수도 함께 기록하기
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int K, W, H;
	static int[][] map, mDeltas, hDeltas;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		mDeltas = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		hDeltas = new int[][] {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};
		K = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		W = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		map = new int[H][W];
		visited = new boolean[K+1][H][W];
		
		for(int r = 0; r < H; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int ans = bfs();
		
		System.out.println(ans);
	}
	
	static int bfs() {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 0, 0, K));
		
		visited[K][0][0] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			int cnt = now.cnt;
			int k = now.k;
			
			if(r == H - 1 && c == W - 1) return cnt;
			
			for(int d = 0; d < 4; d++) {
				int nr = r + mDeltas[d][0];
				int nc = c + mDeltas[d][1];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[k][nr][nc] || map[nr][nc] == 1) continue;
				
				visited[k][nr][nc] = true;
				que.offer(new Pos(nr, nc, cnt+1, k));
			}
			
			if(k > 0) {
				for(int d = 0; d < hDeltas.length; d++) {
					int nr = r + hDeltas[d][0];
					int nc = c + hDeltas[d][1];
					
					if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[k-1][nr][nc] || map[nr][nc] == 1) continue;
					
					visited[k-1][nr][nc] = true;
					que.offer(new Pos(nr, nc, cnt+1, k-1));
				}
			}
		}
		
		return -1;
	}
	
	static class Pos {
		int r;
		int c;
		int cnt;
		int k;
		
		public Pos(int r, int c, int cnt, int k) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.k = k;
		}
	}
}