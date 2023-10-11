import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int ans;
	static int[][] deltas;

	public static void main(String[] args) throws IOException {
		deltas = new int[][] {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
		int[][] map = new int[4][4];
		Fish[] fishes = new Fish[17];
		
		for(int r = 0; r < 4; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 4; c++) {
				int n = Integer.parseInt(tokens.nextToken());
				int d = Integer.parseInt(tokens.nextToken()) - 1;
				map[r][c] = n;
				fishes[n] = new Fish(n, r, c, d);
			}
		}

		dfs(map, fishes, new int[] {0, 0}, 0);
		
		System.out.println(ans);
	}
	
	static int[][] copyMap(int[][] map) {
		int[][] copy = new int[4][4];
		
		for(int r = 0; r < 4; r++) {
			for(int c = 0; c < 4; c++) {
				copy[r][c] = map[r][c];
			}
		}
		
		return copy;
	}
	
	static Fish[] copyFishes(Fish[] fishes) {
		Fish[] copy = new Fish[17];
		
		for(int i = 1; i < 17; i++) {
			copy[i] = new Fish(fishes[i].num, fishes[i].r, fishes[i].c, fishes[i].d, fishes[i].alive);
		}
		
		return copy;
	}
	
	static void dfs(int[][] map, Fish[] fishes, int[] start, int cnt) {
		// 상어가 먹은 물고기 상태 바꾸기
		Fish shark = fishes[map[start[0]][start[1]]];
		map[shark.r][shark.c] = 0;
		fishes[shark.num].alive = false;
		
		// 이전까지 먹은 물고기 번호 합에 현재 먹은 물고기 번호 더해주기
		cnt += shark.num;
		ans = Math.max(cnt, ans);
		
		// 물고기 이동
		moveFishes(map, fishes, shark);
		
		int now_d = shark.d;
		int now_r = shark.r;
		int now_c = shark.c;
		
		// 상어가 이동할 수 있는 곳으로 모두 이동
		for(int i = 1; i < 4; i++) {
			int next_r = now_r + deltas[now_d][0] * i;
			int next_c = now_c + deltas[now_d][1] * i;
			
			if(isIn(next_r, next_c) && map[next_r][next_c] != 0) {
				dfs(copyMap(map), copyFishes(fishes), new int[] {next_r, next_c}, cnt);
			}
		}
	}
	
	static void moveFishes(int[][] map, Fish[] fishes, Fish shark) {
		for(int i = 1; i < 17; i++) {
			// 현재 이동할 물고기의 정보
			int now_r = fishes[i].r;
			int now_c = fishes[i].c;
			int now_num = fishes[i].num;
			int now_d = fishes[i].d;
			
			// 상어거나 죽은 물고기는 건너뛰기
			if(now_num == shark.num || !fishes[i].alive) continue;
			
			for(int d = 0; d < 8; d++) {
				int nd = (now_d + d) % 8; // 이동할 방향
				int next_r = now_r + deltas[nd][0]; // 이동할 칸 r 좌표
				int next_c = now_c + deltas[nd][1]; // 이동할 칸 c 좌표
				
				// 경계를 벗어나거나 상어가 있는 칸이면 다른 방향 확인
				if(!isIn(next_r, next_c) || (next_r == shark.r && next_c == shark.c)) {
					continue;
				}
				
				// 이동할 칸에 물고기가 없으면 현재 물고기 번호를 넣고, 현재 칸을 0으로 비우기
				if(map[next_r][next_c] == 0) {
					map[next_r][next_c] = i;
					fishes[now_num].r = next_r;
					fishes[now_num].c = next_c;
					fishes[now_num].d = nd;
					map[now_r][now_c] = 0;
				} else {
					// 이동할 칸에 있는 물고기
					Fish next = fishes[map[next_r][next_c]];
					
					map[next_r][next_c] = now_num; // 이동할 칸에 현재 물고기 번호 넣기
					map[now_r][now_c] = next.num; // 현재 칸에 다음 칸 물고기 번호 넣기
					
					// 현재 물고기 위치를 이동할 위치로 바꾸기
					fishes[now_num].r = next_r;
					fishes[now_num].c = next_c;
					fishes[now_num].d = nd;
					
					// 이동할 칸에 있는 물고기 위치를 현재 칸으로 바꾸기
					fishes[next.num].r = now_r;
					fishes[next.num].c = now_c;
				}
				
				// 이동했으면 다른 방향을 탐색할 필요 X
				break;
			}
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}
	
	static class Fish {
		int num;
		int r;
		int c;
		int d;
		boolean alive = true;
		
		public Fish(int num, int r, int c, int d) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.d = d;
		}
		
		public Fish(int num, int r, int c, int d, boolean alive) {
			this(num, r, c, d);
			this.alive = alive;
		}
	}
}