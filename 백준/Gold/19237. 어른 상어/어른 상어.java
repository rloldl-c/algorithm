import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, k;
	static int[][] deltas;
	static int[][][] map, priority;
	static Shark[] sharks;
	
	public static void main(String[] args) throws IOException {
		// 1: 위 2: 아래 3: 왼쪽 4: 오른쪽
		deltas = new int[][] {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		k = Integer.parseInt(tokens.nextToken());
		// map[r][c] = {상어 번호, 남은 이동 횟수}
		map = new int[N][N][2];
		priority = new int[M+1][5][4];
		sharks = new Shark[M+1];
		int time = 0;

		// 기본 맵 정보 입력 받기
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c][0] = Integer.parseInt(tokens.nextToken());
				// 맨 처음에 상어가 있는 칸이면 이동 횟수 k 입력
				if(map[r][c][0] != 0) {
					map[r][c][1] = k;
					sharks[map[r][c][0]] = new Shark(r, c);
				}
			}
		}
		
		// 상어의 방향
		tokens = new StringTokenizer(input.readLine());
		for(int i = 1; i <= M; i++) {
			sharks[i].d = Integer.parseInt(tokens.nextToken());
		}
		
		// 상어의 이동 우선 순위
		for(int i = 1; i <= M; i++) {
			for(int j = 1; j < 5; j++) {
				tokens = new StringTokenizer(input.readLine());
				for(int k = 0; k < 4; k++) {
					priority[i][j][k] = Integer.parseInt(tokens.nextToken());
				}
			}
		}

		boolean end = true;
		while(time < 1000) {
			end = true;
			// 상어들 이동
			moveShark();
			// 맵의 이동 횟수 수정
			moveCount();

			time++;
			
			for(int i = 2; i <= M; i++) {
				if(sharks[i].alive) {
					end = false;
					break;
				}
			}
			
			if(end) {
				break;
			}
		}
		
		if(time == 1000 && !end) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}
	
	static void moveCount() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c][0] != 0) {
					if(--map[r][c][1] == 0) {
						map[r][c][0] = 0;
					}
				}
			}
		}
		
		for(int i = 1; i <= M; i++) {
			if(sharks[i].alive) {	
				int r = sharks[i].r;
				int c = sharks[i].c;
				map[r][c][0] = i;
				map[r][c][1] = k;
			}
		}
	}
	
	static void moveShark() {
		// 같은 칸에 두 마리 이상의 상어가 도착하는 경우를 처리해주기 위해 임시 맵에 상어들의 다음 칸을 표시해줌
		int[][] tmp = new int[N][N];
		
		for(int i = 1; i <= M; i++) {
			// 격자 밖으로 쫓겨난 상어는 건너뜀
			if(!sharks[i].alive) continue;
			int r = sharks[i].r;
			int c = sharks[i].c;
			
			// 주위에 이동할 수 있는 방향 확인
			int nd = nextDir(i);
			int nr = r + deltas[nd][0];
			int nc = c + deltas[nd][1];
			
			if(isIn(nr, nc)) {
				// 다음 칸에 상어가 없으면 표시
				if(tmp[nr][nc] == 0) {
					tmp[nr][nc] = i;
					sharks[i].d = nd;
					sharks[i].r = nr;
					sharks[i].c = nc;
				}
				else {
					// 상어가 있으면 더 큰 상어는 내쫓고 살아남은 상어의 위치, 이동방향 수정
					if(tmp[nc][nc] > i) {
						sharks[tmp[nr][nc]].alive = false;
						sharks[i].d = nd;
						sharks[i].r = nr;
						sharks[i].c = nc;
					} else {
						sharks[i].alive = false;
					}
				}
			}
			
		}
	}
	
	static int nextDir(int idx) {
		Shark now = sharks[idx];
		int ans = -1;
		
		for(int d = 0; d < 4; d++) {
			// 현재 상어의 방향 우선순위에 따라 주위에 냄새가 없는 칸이 있는지 확인
			int nd = priority[idx][now.d][d];
			int nr = now.r + deltas[nd][0];
			int nc = now.c + deltas[nd][1];
			
			if(!isIn(nr, nc)) continue;
			
			// 냄새가 없는 칸이 있으면 그 칸으로 갈 수 있는 방향을 바로 리턴
			if(map[nr][nc][0] == 0) {
				return nd;
			}
			
			// 자신의 냄새이면 저장해두기
			if(ans == -1 && map[nr][nc][0] == idx) {
				ans = nd;
			}
		}
		
		return ans;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	static class Shark {
		int r;
		int c;
		int d;
		boolean alive = true;

		public Shark() {}

		public Shark(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}