import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, time;
	static boolean flag;
	static char[][] map;
	static int[][] deltas, visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		visited = new int[R][C];
		int dr = 0, dc = 0;
		
		for(int r = 0; r < R; r++) {
			map[r] = input.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'D') {
					dr = r;
					dc = c;
				}
			}
		}
		
		Deque<Pos> water = new ArrayDeque<>();
		Deque<Pos> dochi = new ArrayDeque<>();
		
		while(!flag) {
			time++;
			int cnt = 0;

			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] == '*') {
						water.add(new Pos(r, c));
					}
					
					if(map[r][c] == 'S' ) {
						dochi.add(new Pos(r, c));
					}
				}
			}
			
			cnt += spreadWater(water);	
			cnt += moveDochi(dochi);	
			
			if(cnt == 0 && visited[dr][dc] == 0) {
				time = -1;
				break;
			}
		}
		
		System.out.println(time == -1 ? "KAKTUS" : time);
	}
	
	static int moveDochi(Deque<Pos> dochi) {
		int cnt = 0;
		
		while(!dochi.isEmpty()) {
			Pos now = dochi.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				
				if(!isIn(nr, nc)) continue;

				if(visited[nr][nc] == 0) {						
					visited[nr][nc] = time;
				}
				
				if(map[nr][nc] == 'D') {
					flag = true;
					return cnt;
				}
				
				if(map[nr][nc] == '.') {					
					map[nr][nc] = 'S';
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static int spreadWater(Deque<Pos> water) {
		int cnt = 0;
		
		while(!water.isEmpty()) {
			Pos now = water.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];

				if(isIn(nr, nc) && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static class Pos {
		int r;
		int c;
		int cnt;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public Pos(int r, int c, int cnt) {
			this(r, c);
			this.cnt = cnt;
		}
	}
}