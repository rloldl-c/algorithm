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
하루에 익힐 수 있는 토마토 양 제한하기 -> 이전 턴에서 저장한 토마토 개수
모든 탐색이 끝나면 익지 않은 토마토가 있는지 확인하고
안 익은 토마토가 있다면 -1 출력
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, H, cnt, days, boxes[][][], dh[], dr[], dc[];
	static boolean visited[][][];
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
		visited = new boolean[H][N][M];
		que = new ArrayDeque<>();
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < M; c++) {
					boxes[h][r][c] = Integer.parseInt(tokens.nextToken());
					
					if(boxes[h][r][c] == 1) {
						que.offer(new Tomato(h, r, c));
					}
				}
			}
		}
		
		bfs();
		
		System.out.println(days);
		
	}

	static void bfs() {
		days = 0;
				
		while(!que.isEmpty()) {
			cnt = que.size();
			days++;
			
			for(int i = 0; i < cnt; i++) {				
				Tomato t = que.poll();
				int h = t.h;
				int r = t.r;
				int c = t.c;
				
				for(int d = 0; d < 6; d++) {
					int nh = h + dh[d];
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(isIn(nh, nr, nc) && boxes[nh][nr][nc] == 0) {
						boxes[nh][nr][nc] = 1;
						que.offer(new Tomato(nh, nr, nc));
					}
				}
			}
		}
		
		for(int h = 0; h < H; h++) {
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(boxes[h][r][c] == 0) {
						days = -1;
						return;
					}
				}
			}
		}
		
		days--;
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
	
	Tomato(int h, int r, int c) {
		this.h = h;
		this.r = r;
		this.c = c;
	}
}
