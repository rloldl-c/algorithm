import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, total;
	static int[][] map, deltas;
	static ArrayList<Integer> res;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		res = new ArrayList<>();
		visited = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			String s = input.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 1) {
					total++;
					bfs(r, c);
				}
			}
		}
		
		Collections.sort(res);
		
		output.append(total).append("\n");
		for(int i = 0; i < res.size(); i++) {
			output.append(res.get(i)).append("\n");
		}
		
		System.out.println(output);
	}
	
	static void bfs(int r, int c) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(r, c));
		map[r][c]= 0; 
		visited[r][c] = true;
		int cnt = 1;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			r = now.r;
			c = now.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
					que.offer(new Pos(nr, nc));
					map[nr][nc] = 0;
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		
		res.add(cnt);
	}

}

class Pos {
	int r;
	int c;
	
	Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}