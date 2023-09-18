/**
* @author 은비
* @since 2023-09-18
* @see https://www.acmicpc.net/problem/17836
* @performance
* @category #bfs
* @note 
* 기본 bfs 탐색에 que에 넣을 때 시간, 검 획득 여부도 함께 저장
* 벽을 부술 수 있는 검을 찾았는지 여부를 확인해서 현재 검이 없으면 벽을 빼고 탐색
* 검이 있으면 벽을 신경쓰지 않고 탐색
* 검이 있을 때와 없을 때는 다른 경우다 -> visited에도 검이 있을 때 없을 때를 구분해서 기록
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, T, ans;
	static int[][] map, deltas;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		T = Integer.parseInt(tokens.nextToken());
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		visited = new boolean[2][N][M];
		map = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		ans = bfs();
		
		// 끝에 도달할 수 없거나 제한 시간을 넘으면 실패
		if(ans == -1 || ans > T) {
			System.out.println("Fail");
		} else {
			System.out.println(ans);
		}
	}
	
	static int bfs() {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(0, 0, 1, 0));
		visited[0][0][0] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			int r = now.r;
			int c = now.c;
			int t = now.t;
			int gram = now.gram;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[gram][nr][nc]) {
					continue;
				}
				
				if(nr == N-1 && nc == M-1) {
					return t;
				}

				// 다음 칸이 벽인데 현재 검이 없다면 건너뜀
				if(map[nr][nc] == 1 && gram == 0) {
					continue;
				}

				// 다음 칸에 검이 있으면 획득
				if(map[nr][nc] == 2) {
					gram = 1;
				}
				
				visited[gram][nr][nc] = true;
				que.offer(new Pos(nr, nc, t+1, gram));				
			}
		}
		
		return -1;
	}
	
	static class Pos {
		int r;
		int c;
		int t;
		int gram;
		
		public Pos(int r, int c, int t, int gram) {
			super();
			this.r = r;
			this.c = c;
			this.t = t;
			this.gram = gram;
		}
	}
}