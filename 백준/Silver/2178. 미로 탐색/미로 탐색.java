import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Pos {
	int r;
	int c;
	
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M, arr[][], deltas[][]; 
	static boolean visited[][];
	static ArrayDeque<Pos> que;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		que = new ArrayDeque<>();
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine().toString());
			String line = tokens.nextToken();
			
			for(int c = 0; c < M; c++) {
				arr[r][c] = line.charAt(c) - '0';
			}
		}
		
		bfs();
		
		System.out.println(arr[N-1][M-1]);

	}
	
	static void bfs() {
		que.offer(new Pos(0, 0));
		
		int r = 0;
		int c = 0;
		
		while(!que.isEmpty()) {
			Pos curPos = que.poll();
			
			r = curPos.r;
			c = curPos.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 1 && !visited[nr][nc]) {
					arr[nr][nc] += arr[r][c];
					visited[nr][nc] = true;
					que.offer(new Pos(nr, nc));
				}
			}
		}
	}
}
