/**
@author 은비
@since 2023-08-09
@see https://www.acmicpc.net/problem/7569
@performance
@category #BFS, 3차원 배열
@note 
boxes[h][r][c]에 입력으로 들어오는 토마토 상태 모두 저장
3차원 배열을 탐색하면서 익은 토마토를 만나면 bfs 탐색 시작
6방향으로 탐색하면서 주위에 익지 않은 토마토가 있는지 확인
모든 탐색이 끝나면 익지 않은 토마토가 있는지 확인하고
안 익은 토마토가 있다면 -1 출력
총 며칠이 걸렸는지를 체크해야 하므로 토마토 좌표를 저장할 때 현재가 며칠 째인지도 함께 저장해서
큐에서 뺐을 때 이전 날짜에 1을 더해가면서 체크
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, H, cnt, day, boxes[][][], dh[], dr[], dc[];
	static Deque<Tomato> que;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		M = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(tokens.nextToken());
		H = Integer.parseInt(tokens.nextToken());
		dh = new int[] {1, -1, 0, 0, 0, 0};
		dr = new int[] {0, 0, 1, -1, 0, 0};
		dc = new int[] {0, 0, 0, 0, 1, -1};
		boxes = new int[H][N][M];
		que = new ArrayDeque<>();
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < M; c++) {
					boxes[h][r][c] = Integer.parseInt(tokens.nextToken());
					
					if(boxes[h][r][c] == 1) {
						que.offer(new Tomato(h, r, c, 0));
					}
				}
			}
		}
		
		bfs();
		
		System.out.println(day);
		
	}

	static void bfs() {
				
		while(!que.isEmpty()) {		
			Tomato t = que.poll();
			int h = t.h;
			int r = t.r;
			int c = t.c;
			day = t.day;
			
			for(int d = 0; d < 6; d++) {
				int nh = h + dh[d];
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(isIn(nh, nr, nc) && boxes[nh][nr][nc] == 0) {
					boxes[nh][nr][nc] = 1;
					que.offer(new Tomato(nh, nr, nc, day+1));
				}
			}
		}
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(boxes[h][r][c] == 0) {
						day = -1;
						return;
					}
				}
			}
		}
		
		return;
	}
	
	static boolean isIn(int h, int r, int c) {
		return 0 <= h && h < H && 0 <= r && r < N && 0 <= c && c < M;
	}
}

class Tomato {
	int h;
	int r;
	int c;
	int day;
	
	Tomato(int h, int r, int c, int day) {
		this.h = h;
		this.r = r;
		this.c = c;
		this.day = day;
	}
}
