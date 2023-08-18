/**
* @author 은비
* @since 2023-08-18
* @see https://www.acmicpc.net/problem/1987
* @performance
* @category #dfs
* @note 
* 갈 수 있는 모든 경로를 탐색하고 그 중에 최대 경로 찾기 -> dfs로 찾기
* 지나온 알파벳은 다시 지나갈 수 없음 -> visited를 알파벳으로 판단
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, max;
	static int[][] deltas;
	static char[][] map;
	static boolean[] charVisited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		deltas = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		map = new char[R][C];
		charVisited = new boolean[27];
		
		for(int r = 0; r < R; r++) {
			String s = input.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		dfs(0, 0, 1);
		
		System.out.println(max);
	}
	
	static void dfs(int r, int c, int cnt) {
		max = Math.max(cnt, max);
		charVisited[map[r][c]-'A'] = true;
		
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(!charVisited[map[nr][nc]-'A']) {
					charVisited[map[nr][nc]-'A'] = true;
					dfs(nr, nc, cnt+1);
					charVisited[map[nr][nc]-'A'] = false;
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