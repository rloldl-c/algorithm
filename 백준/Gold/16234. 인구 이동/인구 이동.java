/**
* @author 은비
* @since 2023-09-03
* @see https://www.acmicpc.net/problem/16234
* @performance
* @category #BFS
* @note 
* 1. 인구 이동이 한 번도 일어나지 않을 때까지 반복
* -> while문, 인구 이동이 일어났는지를 체크하는 boolean 변수 필요
* 2. 인접한 나라의 인구 수 차이에 의해 국경선을 열지 말지를 결정
* -> 모든 나라마다 bfs탐색을 수행하면서 인구 수 차이를 구함
* 3. 국경선을 열었다면 하나의 연합에 포함된 것
* -> 하나의 연합에 포함된 나라를 관리할 별도의 자료구조 필요(큐 사용)
* 4. 하나의 연합에 포함된 나라들은 같은 인구 수를 가짐
* -> 하나의 연합에 포함된 나라 수를 저장할 cnt 변수와 모든 인구수를 더한 값을 저장할 sum 변수 각각 필요
* -> 연합용 큐에 나라를 넣을 때마다 cnt+1, sum+해당 나라의 인구 수를 더해줌
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, L, R, day;
	static int[][] map, deltas;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		L = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		deltas = new int[][] {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		while(true) {
			boolean flag = false; // 이번 날짜에 인구 이동이 일어났는지를 저장할 변수
			boolean[][] visited = new boolean[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(!visited[r][c]) {
						visited[r][c] = true;
						boolean tmp = bfs(visited, r, c);
						
						if(tmp) {
							flag = true;
						}
					}
				}
			}
			
			if(!flag) {
				break;
			}
			
			day++;
		}
		
		System.out.println(day);
	}
	
	static boolean bfs(boolean[][] visited, int r, int c) {
		Deque<Pos> que = new ArrayDeque<>(); // bfs용 큐
		Deque<Pos> que2 = new ArrayDeque<>(); // 연합용 큐
		que.offer(new Pos(r, c));
		que2.offer(new Pos(r, c));		
		
		int cnt = 1; // 하나의 연합에 포함된 나라 수
		int sum = map[r][c]; // 하나의 연합에 포함된 인구 수
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			r = now.r;
			c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
					int diff = Math.abs(map[r][c] - map[nr][nc]);
					if(diff >= L && diff <= R) {
						cnt++;
						sum += map[nr][nc];
						visited[nr][nc] = true;
						que.offer(new Pos(nr, nc));
						que2.offer(new Pos(nr, nc));
					}
				}
			}
		}
		
		if(cnt != 1) {
			int tmp = sum / cnt; // 연합에 포함된 각 나라의 인구 수
			while(!que2.isEmpty()) {
				Pos now = que2.poll();
				int nr = now.r;
				int nc = now.c;
				map[nr][nc] = tmp;
			}
		} else {
			return false;
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