/**
* @author 은비
* @since 2023-08-18
* @see https://www.acmicpc.net/problem/17135
* @performance
* @category #조합 #브루트포스
* @note 
* 궁수의 위치는 성 위치에만 배치할 수 있으므로 제한적임 
* -> 궁수의 위치를 조합으로 구하기
* 궁수의 위치를 구할 때마다 게임을 진행
* 궁수 위치마다 최소 거리의 적을 구해줌
* 최소 거리의 적이 하나 이상이면 c 좌표를 비교해서 가장 왼쪽에 있는 적이 선택될 수 있도록 좌표값 갱신
* 하나의 적이 여러 궁수의 공격을 받을 수 있으므로 바로바로 제거해주는 것이 아니라 모든 궁수의 위치에서 판단 후 제거해야 함
* -> visited 배열로 궁수마다 최소 거리의 적을 true로 표시 후, 모든 궁수의 위치에서 공격이 끝난 후 한 번에 죽임
* 죽일 때마다 kill 변수에 +1 해주고 적을 아래로 이동
* 모든 턴이 끝나면 현재 죽인 적 수와 전체 턴에서 죽인 수를 비교해서 최대값을 갱신
*/
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, D, max;
	static Shooter[] shooters;
	static int[][] map;

	static class Shooter{
		int r;
		int c;
		
		public Shooter(int r, int c, int D) {
			super();
			this.r = r;
			this.c = c;
		}
		
		// 궁수와 (r, c) 위치의 적 사이 거리
		public int distance(int r, int c) {
			return Math.abs(r - this.r) + Math.abs(c - this.c);
		}
	}
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 행
		M = Integer.parseInt(tokens.nextToken()); // 열
		D = Integer.parseInt(tokens.nextToken()); // 공격거리
		max = 0; // 제거한 적 수 최대값
		map = new int[N][M];
		shooters = new Shooter[3]; // 궁수 수 3명 저장
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
        // 궁수 거리를 바꿔서 게임 실행
		combi(0, 0, new int[3]);
		
		System.out.println(max);
	}
	
	// 궁수의 자리를 바꿔줄 함수(조합)
	private static void combi(int nth, int start, int[] res) {
		if (nth == 3) {		
			// 궁수 위치가 바뀔 때마다 원본 맵을 복사해서 게임에 사용
			int[][] copy = new int[N][M];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					copy[r][c] = map[r][c];
				}
			}

			// 바뀐 위치에 맞게 궁수 배치
			for(int i = 0; i < 3; i++) {
				shooters[i] = new Shooter(N, res[i], D);
			}
			
			// 원본 맵을 복사한 맵으로 게임
			game(copy);

			return;
		}
		
		for(int i = start; i < M; i++) {
			res[nth] = i;
			combi(nth+1, i+1, res);
		}
	}

	private static void game(int[][] map) {
		int kill = 0; // 이번 턴에서 죽인 적의 수
		
		// 최대 N 턴(적이 최대 N번 내려올 수 있음)
		for(int t = 0; t < N; t++) {
			boolean[][] visited = new boolean[N][M];
			// 궁수 수만큼 반복
			for(int s = 0; s < 3; s++) {
				int minD = Integer.MAX_VALUE; // 현재 궁수 위치에서 최소 위치
				int minR = Integer.MAX_VALUE; // 현재 궁수 위치에서 최소 r 위치
				int minC = Integer.MAX_VALUE; // 현재 궁수 위치이세 최소 c 위치

				for(int r = 0; r < N; r++ ) {
					for(int c = 0; c < M; c++) {
						// 현재 위치가 적이면
						if(map[r][c] == 1) {
							// 현재 위치와 궁수의 거리를 구하고 최소 거리인지 비교해서 갱신
							// 최소 위치라면 가장 왼쪽에 있는 적이게 갱신
							
							// 현재 적과 궁수의 거리
							int nowD = shooters[s].distance(r, c);
							
							// 이전에 저장한 최소 거리보다 현재 적의 거리가 더 작으면
							if(minD >= nowD) {
								// 최소 거리와 좌표 갱신
								if(minD > nowD) {
									minD = nowD;
									minR = r;
									minC = c;
								} else {
									// 만약 최소 거리가 같다면 가장 왼쪽에 있는 적으로 갱신
									if(minC > c) {										
										minR = r;
										minC = c;
									}
								}
							}
						}
					}
				}
				
				// 구한 최소 거리의 적이 궁수의 공격 거리 내에 있다면 죽일 수 있음을 표시
				if(minD <= D) {
					visited[minR][minC] = true;
				}

			}
			
			// 모든 궁수들이 죽일 수 있는 적을 죽이고 그만큼을 kill에 더해줌
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					if(visited[r][c]) {
						map[r][c] = 0;
						kill++;
					}
				}
			}
			
			// 적을 아래로 이동
			for(int r = N-1; r >= 1; r--) {
				for(int c = 0; c < M; c++) {
					map[r][c] = map[r-1][c];
				}
			}

			// 맨 위에 있는 줄은 0으로
			for(int c = 0; c < M; c++) {
				map[0][c] = 0;
			}

		}

		max = Math.max(kill, max);
	}
}