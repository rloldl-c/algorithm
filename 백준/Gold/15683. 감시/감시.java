/**
* @author 은비
* @since 2023-08-22
* @see https://www.acmicpc.net/problem/15683
* @performance
* @category #구현
* @note 
* < CCTV 감시구역 설정하기 >
* 1번 우 하 좌 상 -> 4방향
* 2번 좌우 상화 -> 2방향
* 3번 상우 우하 좌하 좌상 -> 4방향
* 4번 좌상우 상하우 좌하우 좌상하 -> 4방향
* 5번 상하좌우 -> 1방향
* 상 하 좌 우 방향을 살펴보는 메서드를 각각 작성 후 타입과 방향에 맞게 메서드를 호출해서 감시하는 구역 살피기
* -----------------------------------------------
* 입력 받으면서 cctv가 있는 좌표들 따로 저장해두기
* 4방향을 탐색하면서 모든 cctv의 방향 설정해주기
* -> 설정해준 방향으로 감시할 수 있는 구역을 맵에 표시해줘야 하므로 방향을 바꿔줄 때마다 기존 맵 정보를 복사해서 사용하기
* 모든 카메라 방향을 설정해줬으면 사각지대가 몇개인지 세기
*/
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[][] map;
	static ArrayList<CCTV> cctvs;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());		
		map = new int[N][M];
		cctvs = new ArrayList<>();
		ans = Integer.MAX_VALUE;
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] != 0 && map[r][c] != 6) {
					cctvs.add(new CCTV(r, c, map[r][c]));
				}
			}
		}
		
		if(cctvs.size() != 0) {
			setDirection(0, map);			
		} else {
			countNoCCTV(map);
		}
		
		System.out.println(ans);
	}
	
	// 기존 방 정보를 복사해주는 메서드
	static void copy(int[][] origin, int[][] copy) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				copy[r][c] = origin[r][c];
			}
		}
	}
	
	// 방에 있는 모든 감시카메라의 방향을 설정하는 메서드
	static void setDirection(int num, int[][] map) {
		int[][] tmpMap = new int[N][M];
		
        // 기존 방 정보를 복사
		copy(map, tmpMap);
		
		int r = cctvs.get(num).r;
		int c = cctvs.get(num).c;
		int type = cctvs.get(num).type;
		
		// 한 대의 카메라는 총 4 방향을 감시할 수 있으므로 방향별로 모두 탐색
		for(int d = 0; d < 4; d++) {
			// 현재 설정된 카메라 방향에 맞게 감시구역 설정
			setArea(tmpMap, type, d, r, c);
			
			// 방에 있는 모든 카메라 방향을 설정했으면 사각지대 수 세기
			if(num == cctvs.size()-1) {
				countNoCCTV(tmpMap);
			}

			for(int i = num+1; i < cctvs.size(); i++) {
				// 다음 카메라 방향 설정하기
				setDirection(i, tmpMap);
			}
			
            // 이전 방 정보로 다시 되돌아가기
			copy(map, tmpMap);
		}
	}
	
	// 감시 카메라 방향에 맞게 감시 구역을 설정하는 메서드
	static void setArea(int[][] tmpMap, int cctvType, int direction, int r, int c) {
		switch (cctvType) {
		case 1: // 한 방향 감시
			if(direction == 0) {
				right(r, c, tmpMap);
			} else if (direction == 1) {
				down(r, c, tmpMap);
			} else if (direction == 2) {
				left(r, c, tmpMap);
			} else {
				up(r, c, tmpMap);
			}
			
			break;

		case 2: // 두 방향 감시
			if(direction == 0 || direction == 2) {
				up(r, c, tmpMap);
				down(r, c, tmpMap);
			} else {
				left(r, c, tmpMap);
				right(r, c, tmpMap);
			}
			break;
			
		case 3: // 직각 방향 감시
			if(direction == 0) {
				up(r, c, tmpMap);
				right(r, c, tmpMap);
			} else if (direction == 1) {
				right(r, c, tmpMap);
				down(r, c, tmpMap);
			} else if (direction == 2) {
				left(r, c, tmpMap);
				down(r, c, tmpMap);
			} else {
				up(r, c, tmpMap);
				left(r, c, tmpMap);
			}
			
			break;
			
		case 4: // 3방향 감시
			if(direction == 0) {
				left(r, c, tmpMap);
				up(r, c, tmpMap);
				right(r, c, tmpMap);
			} else if (direction == 1) {
				up(r, c, tmpMap);
				down(r, c, tmpMap);
				right(r, c, tmpMap);
			} else if (direction == 2) {
				left(r, c, tmpMap);
				down(r, c, tmpMap);
				right(r, c, tmpMap);
			} else {
				left(r, c, tmpMap);
				up(r, c, tmpMap);
				down(r, c, tmpMap);
			}
			
			break;
			
		case 5: // 4방향 모두 감시
			up(r, c, tmpMap);
			right(r, c, tmpMap);
			left(r, c, tmpMap);
			down(r, c, tmpMap);
			
			break;
			
		default:
			break;
		}
	}
	
	static void up(int r, int c, int[][] map) {
		for(int nr = r-1; nr >= 0; nr--) {
			if(map[nr][c] == 6) { // 벽에 막히면 더 이상 감시할 수 없음
				return;
			} else if(map[nr][c] == 0) {
				map[nr][c] = -1; // 감시 가능한 구역은 -1로 설정
			}
		}
	}
	
	static void right(int r, int c, int[][] map) {
		for(int nc = c+1; nc < M; nc++) {
			if(map[r][nc] == 6) {
				return;
			} else if(map[r][nc] == 0) {
				map[r][nc] = -1;
			}
		}
	}

	static void down(int r, int c, int[][] map) {
		for(int nr = r+1; nr < N; nr++) {
			if(map[nr][c] == 6) {
				return;
			} else if(map[nr][c] == 0) {
				map[nr][c] = -1;
			}
		}
	}
	
	static void left(int r, int c, int[][] map) {
		for(int nc = c-1; nc >= 0; nc--) {
			if(map[r][nc] == 6) {
				return;
			} else if(map[r][nc] == 0) {
				map[r][nc] = -1;
			}
		}
	}
	
	
	static void countNoCCTV(int[][] map) {
		int cnt = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) {
					cnt++;
				}
			}
		}
		
		ans = Math.min(ans, cnt);
	}
	
	static class CCTV {
		int r;
		int c;
		int type;
		
		public CCTV(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}

}