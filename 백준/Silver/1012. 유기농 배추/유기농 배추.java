/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/1012
* @performance
* @category #BFS
* @note 
* 상하좌우로 탐색 가능한 BFS
* 배추들이 모여있는 구간이 몇 개인지 탐색
* 영역 탐색이 끝나면 다시 탐색하지 못하도록 0으로 바꾸기
*/
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, K, cnt, arr[][], deltas[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			arr = new int[N][M];
			cnt = 0;
			
			for(int k = 0; k < K; k++) {
				tokens = new StringTokenizer(input.readLine());
				int i = Integer.parseInt(tokens.nextToken());
				int j = Integer.parseInt(tokens.nextToken());
				
				arr[i][j] = 1;
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(arr[r][c] == 1) {
						bfs(r, c);
						cnt++;
					}
				}
			}
			
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
	}
	
	static void bfs(int r, int c) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(r, c));
		
		while(!que.isEmpty()) {
			Pos p = que.poll();
			r = p.r;
			c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					que.offer(new Pos(nr, nc));
				}
			}
		}
	}

}

class Pos {
	int r;
	int c;
	
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
