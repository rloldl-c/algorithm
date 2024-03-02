import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[][] map;
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, visited, 0, 0);
				dfs2(i, j);
				visited[i][j] = false;
			}
		}
		
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, boolean[][] visited, int depth, int total) {
		if(depth == 4) {
			ans = Math.max(ans, total);
			return;
		}
		
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + deltas[i][0];
			int nc = c + deltas[i][1];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] = true;
			dfs(nr, nc, visited, depth+1, total+map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	// ㅓ, ㅏ, ㅗ, ㅜ 모양은 dfs로 만들 수 없음
	static void dfs2(int r, int c) {
		for(int i = 1; i <= 4; i++) {
			int total = map[r][c];
			
			for(int j = 0; j < 3; j++) {
				int nr = r + deltas[(i+j) % 4][0];
				int nc = c + deltas[(i+j) % 4][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					total += map[nr][nc];
				}
			}
			
			ans = Math.max(total, ans);
		}
	}
}