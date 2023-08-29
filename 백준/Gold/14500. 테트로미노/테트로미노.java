/**
 * @author 은비
 * @since 2023-08-29
 * @see https://www.acmicpc.net/problem/14500
 * @performance 
 * @category #dfs #완전탐색
 * @note
 * dfs 탐색으로 만들 수 있는 모든 모양 만들기
 * dfs 탐색만으로 만들 경우 ㅓㅏㅗㅜ 모양은 만들 수 없음
 * -> 이 모양은 주변 4칸 중에 3칸을 골라서 만드는 모양이므로 주위 4칸 중 3칸만 골라서 따로 계산해주고, 최대값 갱신하기
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, max;
	static int[][] map, deltas;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		deltas = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				visited[r][c] = true;
				dfs(r, c, visited, 0, 0);
				around(r, c);
				visited[r][c] = false;
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(int r, int c, boolean[][] visited, int depth, int score) {
		if(depth == 4) {
			max = Math.max(max, score);
			return;
		}
		
		int nr = r;
		int nc = c;
		visited[r][c] = true;
		
		for(int d = 0; d < deltas.length; d++) {
			nr = r + deltas[d][0];
			nc = c + deltas[d][1];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, visited, depth+1, score+map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}
	
	static void around(int r, int c) {
		
		for(int i = 0; i < 4; i++) {
			int score = map[r][c];
			for(int d = 0; d < 3; d++) {
				int nr = r + deltas[(d+i)%4][0];
				int nc = c + deltas[(d+i)%4][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					score += map[nr][nc];
				}
				max = Math.max(max, score);
			}

		}
	}
	
	static void swap(int a, int b, int[] arr) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	private static String src = "4 10\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1\r\n" + 
			"1 2 1 2 1 2 1 2 1 2\r\n" + 
			"2 1 2 1 2 1 2 1 2 1";
}