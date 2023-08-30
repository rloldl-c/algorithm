import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, M, cnt;
	static int[][] map;
	static int[][] deltas;
	static ArrayList<Shark> sharkList;
	
	static class Shark {
		int r;
		int c;
		int s; // 속력
		int d; // 방향
		int z; // 크기
		boolean live = true; // 낚시왕한테 잡혔거나, 다른 상어한테 잡아먹혔는지를 표시
		
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		cnt = 0;
		map = new int[R][C]; // 칸에 상어가 몇 마리 있는지 표시해야 하기 때문에 int형으로 2차원 배열 만들기
		deltas = new int[][] {{0, 0}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		sharkList = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			int s = Integer.parseInt(tokens.nextToken());
			int d = Integer.parseInt(tokens.nextToken());
			int z = Integer.parseInt(tokens.nextToken());
			Shark shark = new Shark(r, c, s, d, z);
			// 상어가 있는 위치 표시
			map[r][c]++;
			sharkList.add(shark);
		}
		
		// 상어 왕이 움직이는 영역: 최대 C
		int i = 0;
		while(true) {
			if(i >= C) break;
			
			// 현재 땅에서 가장 가까운 상어 잡기
			int sharkIdx = -1;
			for(int r = 0; r < R; r++) {
				for(int s = 0; s < M; s++) {
					if(sharkList.get(s).live && sharkList.get(s).r == r && sharkList.get(s).c == i) {
						sharkIdx = s;
						break;
					}
					
				}
				
				if(sharkIdx != -1) {
					sharkList.get(sharkIdx).live = false; // 해당 상어는 죽었음을 표시
					cnt += sharkList.get(sharkIdx).z; // 상어 크기 더해주기
					break;					
				}
				
			}
			
			// 상어가 이동해야 하므로 판 초기화
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					map[r][c] = 0;
				}
			}
			
			for(int s = 0; s < M; s++) {
				// 살아있는 상어들만 움직임
				if(sharkList.get(s).live) {
					moveShark(s);
				}
			}
			
			// 한 칸에 상어가 한 마리씩 있는지 확인
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					if(map[r][c] >= 2) {
						eat(r, c);
					}
				}
			}
			
			i++;
		}
		
		System.out.println(cnt);
	}
	
	static void moveShark(int idx) {
		int r = sharkList.get(idx).r;
		int c = sharkList.get(idx).c;
		int d = sharkList.get(idx).d;
		int s = sharkList.get(idx).s;
		
		// 특정 횟수가 되면 원래 위치와 똑같아짐 -> 나머지 연산으로 이동 횟수 줄이기
		// 상어 방향이 상하
		if(d == 1 || d == 2) {
			s %= (R-1) * 2;
		}
		// 상어 방향이 좌우
		if(d == 3 || d == 4) {
			s %= (C-1) * 2;
		}
		
		// 상어가 이동 가능한 만큼 이동시키기
		while(true) {
			if(s <= 0) break;
			
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			// 범위를 벗어나면 방향을 바꿈
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) {
				if(d == 1) {
					d = 2;
				} else if(d == 2) {
					d = 1;
				} else if(d == 3) {
					d = 4;
				} else if(d == 4) {
					d = 3;
				}
				nr = r + deltas[d][0];
				nc = c + deltas[d][1];
			}
			
			r = nr;
			c = nc;
			s--;
		}
		
		// 이동한 상어의 위치와 방향을 업데이트 시켜주고, 맵에 상어가 생겼다고 표시
		sharkList.get(idx).r = r;
		sharkList.get(idx).c = c;
		sharkList.get(idx).d = d;
		map[r][c]++;
	}
	
	static void eat(int r, int c) {
		int sharkSize = -1;
		int sharkIdx = -1;
		
		// 상어 리스트에서 2마리 이상 있는 칸 위치에 있는 상어들 찾기
		for(int i = 0; i < M; i++) {
			if(sharkList.get(i).live && sharkList.get(i).r == r && sharkList.get(i).c == c) {
				// 기존에 있던 상어보다 현재 상어가 크면 기존에 있던 상어를 죽임
				if(sharkSize < sharkList.get(i).z) {
					sharkSize = sharkList.get(i).z;
					if(sharkIdx != -1) {
						sharkList.get(sharkIdx).live = false;
					}
					sharkIdx = i;
				// 반대면 현재 상어를 죽임
				} else if (sharkSize > sharkList.get(i).z) {
					sharkList.get(i).live = false;
				}
			}
		}
	}
}