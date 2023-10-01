/**
* @author 은비
* @since 2023-10-01
* @see https://www.acmicpc.net/problem/17244
* @performance
* @category #bfs #순열?
* @note 
* 모든 물건을 챙기고 나갈 수 있는 최소 거리
* 현재위치 - 물건1 - 물건2 - ... - 물건5 - 문
* 현재위치 - 물건1 최소거리
* 물건1 - 물건2 최소거리
* ...
* 각각의 위치에서 최소 거리를 구하고 모두 더하면 결국 모든 물건을 챙겨서 나갈 수 있는 최소 거리가 되지 않을까?
* 어느 물건을 먼저 집느냐에 따라 거리가 달라지므로 물건 순서를 정해줘야 함 
* -> np로 순서 정해주고 시작점과 끝점을 포함해서 bfs로 거리 구해주기
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[] targetIdx;
	static char[][] map;
	static int[][] deltas;
	static List<Pos> targets;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		Pos start = new Pos();
		Pos end = new Pos();
		targets = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for(int r = 0; r < N; r++) {
			map[r] = input.readLine().toCharArray();
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 'S') {
					start.r = r;
					start.c = c;
				}
				
				if(map[r][c] == 'E') {
					end.r = r;
					end.c = c;
				}
				
				if(map[r][c] == 'X') {
					targets.add(new Pos(r, c));
				}
			}
		}
		
		targetIdx = new int[targets.size()];
		for(int i = 0; i < targets.size(); i++) {
			targetIdx[i] = i;
		}

		if(targets.size() > 0) {
			do {
				int time = 0;
				time += bfs(start, targets.get(targetIdx[0]));
				
				for(int i = 0; i < targets.size()-1; i++) {
					time += bfs(targets.get(targetIdx[i]), targets.get(targetIdx[i+1]));
				}
				
				time += bfs(targets.get(targetIdx[targets.size()-1]), end);
				
				ans = Math.min(time, ans);
			} while (np());			
		} else {
			ans = bfs(start, end);
		}
		
		System.out.println(ans);
	}
	
	static int bfs(Pos start, Pos end) {
		Deque<Pos> que = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		que.offer(start);
		visited[start.r][start.c] = true;
		int time = 0;

		while(!que.isEmpty()) {
			int size = que.size();

			while(size-- > 0) {
				Pos now = que.poll();
				int r = now.r;
				int c = now.c;
				
				for(int d = 0; d < deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == '#') {
						continue;
					}
					
					if(nr == end.r && nc == end.c) {
						return ++time;
					}
					
					que.offer(new Pos(nr, nc));
					visited[nr][nc] = true;
				}
			}
			
			time++;
		}
		
		return 0;
	}
	
	static boolean np() {
		int lastPeak = targetIdx.length - 1;
		
		while(lastPeak > 0 && targetIdx[lastPeak - 1] > targetIdx[lastPeak]) {
			lastPeak--;
		}
		
		if(lastPeak == 0) {
			return false;
		}
		
		int nextPeak = targetIdx.length - 1;
		while(targetIdx[lastPeak-1] > targetIdx[nextPeak]) {
			nextPeak--;
		}

		int tmp = targetIdx[lastPeak-1];
		targetIdx[lastPeak-1] = targetIdx[nextPeak];
		targetIdx[nextPeak] = tmp;
		
		Arrays.sort(targetIdx, lastPeak, targetIdx.length);
		return true;
	}
 
	static class Pos {
		int r;
		int c;

		public Pos() {}
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}