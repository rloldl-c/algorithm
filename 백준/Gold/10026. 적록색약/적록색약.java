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
	static int N, RGB, noRGB;
	static int[][] deltas;
	static char[][] map;
	static boolean[][] RGBvisited, noRGBvisited;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		RGBvisited = new boolean[N][N];
		noRGBvisited = new boolean[N][N];

		for(int r = 0; r < N; r++) {
			String s = input.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!noRGBvisited[r][c]) {
					noRGB++;
					noRGBbfs(r, c, map[r][c]);
				}
				
				if(!RGBvisited[r][c]) {
					RGB++;
					RGBbfs(r, c, map[r][c]);
				}
			}
		}
		
		System.out.println(RGB + " " + noRGB);
	}
	
	private static void noRGBbfs(int r, int c, char color) {
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
					if(!noRGBvisited[nr][nc]) {
						if(color == 'B' && map[nr][nc] == 'B') {
							noRGBvisited[nr][nc] = true;
							que.offer(new Pos(nr, nc));
						} else if((color == 'G' || color == 'R') && (map[nr][nc] == 'G' || map[nr][nc] == 'R')) {
							noRGBvisited[nr][nc] = true;
							que.offer(new Pos(nr, nc));							
						}
					}
				}
			}
		}
	}
	
	private static void RGBbfs(int r, int c, char color) {
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
					if(!RGBvisited[nr][nc]) {
						if(color == 'R' && map[nr][nc] == 'R') {
							RGBvisited[nr][nc] = true;
							que.offer(new Pos(nr, nc));
						} else if(color == 'G' && map[nr][nc] == 'G') {
							RGBvisited[nr][nc] = true;
							que.offer(new Pos(nr, nc));
						} else if(color == 'B' && map[nr][nc] == 'B') {
							RGBvisited[nr][nc] = true;
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