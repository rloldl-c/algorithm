/**
* @author 은비
* @since 2023-08-21
* @see https://www.acmicpc.net/problem/10026
* @performance
* @category #BFS
* @note 
* 적록색약이 아닌 사람이 보는 색 : R G B
* -> R / G / B로 구분하여 bfs 탐색
* 적록색약이 보는 색 : R+G B
* -> R+G / B로 구분하여 bfs 탐색
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, RGBcnt, noRGBcnt;
	static int[][] deltas;
	static char[][] RGBmap, noRGBmap;
	static boolean[][] RGBvisited, noRGBvisited;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(input.readLine());
		RGBmap = new char[N][N];
		noRGBmap = new char[N][N];
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		RGBvisited = new boolean[N][N];
		noRGBvisited = new boolean[N][N];

		for(int r = 0; r < N; r++) {
			String s = input.readLine();
			for(int c = 0; c < N; c++) {
				RGBmap[r][c] = s.charAt(c);
				noRGBmap[r][c] = s.charAt(c);
				
				if(noRGBmap[r][c] == 'G') {
					noRGBmap[r][c] = 'R';
				}
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!noRGBvisited[r][c]) {
					noRGBcnt++;
					bfs(noRGBmap, noRGBvisited, r, c, noRGBmap[r][c]);
				}
				
				if(!RGBvisited[r][c]) {
					RGBcnt++;
					bfs(RGBmap, RGBvisited, r, c, RGBmap[r][c]);
				}
			}
		}
		
		System.out.println(RGBcnt + " " + noRGBcnt);
	}
	
	private static void bfs(char[][] map, boolean[][] visited, int r, int c, char color) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(r, c));
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			r = now.r;
			c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(!visited[nr][nc]) {
						if(color == map[nr][nc]) {
							visited[nr][nc] = true;
							que.offer(new Pos(nr, nc));
						}
					}
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