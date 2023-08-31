/**
 * @author 은비
 * @since 
 * @see https://www.acmicpc.net/problem/14502
 * @performance 
 * @category 
 * @note
 * dfs로 바이러스 주변에 설치할 수 있는 모든 곳에 벽 설치하기
 * 임시로 설치한 벽이 3개가 되면 바이러스를 퍼뜨리고 안전 영역 크기 구하기
 * 임시로 설치한 벽을 치우고 다른 곳에 다시 설치해서 똑같은 방법으로 안전 영역 크기를 구해서 최대 크기로 갱신해주기
 */
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, max;
	static int[][] map, deltas;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	static void dfs(int cnt) {
		if(cnt == 3) {
			spreadVirus();
			return;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) {
					map[r][c] = 1;
					dfs(cnt+1);
					map[r][c] = 0;
				}
			}
		}
	}
	
	static void spreadVirus() {
		Deque<Pos> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		int[][] tmp = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				tmp[r][c] = map[r][c];
				
				if(map[r][c] == 2) {
					que.add(new Pos(r, c));
				}
			}
		}
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			visited[r][c] = true;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && tmp[nr][nc] == 0) {
					visited[nr][nc] = true;
					tmp[nr][nc] = 2;
					que.offer(new Pos(nr, nc));
				}
			}
		}
		
		int cnt = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(tmp[r][c] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
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