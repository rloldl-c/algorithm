import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[][] map, visited;
	static int[][] deltas = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());

		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		visited = new int[N][M];
		int r = 0;
		int c = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = -1; 
			}
		}
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
				
				if(map[i][j]== 0) visited[i][j]= 0; 
				if(map[i][j]== 2 ) {
					r = i;
					c = j;
				}
			}
		}
		
		bfs(r, c);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				output.append(visited[i][j] + " " );
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	static void bfs(int r, int c) {
		Deque<Pos> que = new ArrayDeque<>();
		visited[r][c] = 0;
		que.add(new Pos(r, c));
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
								
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				
				if(visited[nr][nc] == -1) {
					visited[nr][nc]= visited[now.r][now.c] + 1;
					que.add(new Pos(nr, nc));
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