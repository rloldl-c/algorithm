/**
* @author 은비
* @since 2023-09-17
* @see https://www.acmicpc.net/submit/2636
* @performance
* @category #bfs
* @note 
* 치즈 속의 구멍 = 다른 공기들과 인접하지 않음 -> 인접한 공기들만이 있는 큐 구하기(air)
* 인접한 공기들만이 있는 큐(air)를 가지고 공기와 인접한 치즈 녹이기
* -> bfs로 탐색하면서 1을 0으로 바꿔주면 모든 치즈들이 한 번에 녹을 수 있으므로
* 	현재 큐 사이즈만큼만 탐색하면서 0으로 바꿔주기
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, time, cnt;
	static int[][] map, deltas;
	static Deque<Pos> air;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		air = new ArrayDeque<>();
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		while(true) {
			air.clear();
			
			// 현재 판에 치즈가 하나도 없으면 종료
			if(check()) {
				break;
			}
			
			airBfs();
			time++;
		}
		
		System.out.println(time);
		System.out.println(cnt);
	}
	
	// 인접한 공기들만 큐에 넣어주는 bfs
	static void airBfs() {
		boolean[][] visited = new boolean[N][M];
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 0));
		air.offer(new Pos(0, 0));
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			visited[r][c] = true;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					que.offer(new Pos(nr, nc));
					air.offer(new Pos(nr, nc));
				}
			}
		}
		
		bfs();
	}
	
	static void bfs() {
		boolean[][] visited = new boolean[N][M];
		int size = air.size();
		cnt = 0;
		
		while(--size >= 0) {
			Pos now = air.poll();
			int r = now.r;
			int c = now.c;
			visited[r][c] = true;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
					continue;
				}
				
				if(map[nr][nc] == 1) {
					cnt++;
					map[nr][nc] = 0;
					visited[nr][nc] = true;
					air.offer(new Pos(nr, nc));
				}
			}	
		}
	}
	
	static boolean check() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1) {
					return false;
				}
			}
		}
		
		return true;
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