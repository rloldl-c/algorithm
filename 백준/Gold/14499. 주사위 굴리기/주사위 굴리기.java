/**
* @author 은비
* @since 2023-10-07
* @see https://www.acmicpc.net/problem/14499
* @performance
* @category #구현
* @note 
* 1. 이동할 칸이 지도 안에 있는지 확인
* 1-1. 지도 바깥이면 continue
* 2. 주사위 굴리기
* (위 - 북 - 동 - 서 - 남 - 아래 방향 순으로)
* 처음: 1 - 2 - 3 - 4 - 5 - 6
* 동: 4 - 2 - 1 - 6 - 5 - 3
* 서: 3 - 2 - 6 - 1 - 5 - 4
* 남: 2 - 6 - 3 - 4 - 1 - 5
* 북: 5 - 1 - 3 - 4 - 6 - 2
* 3. 이동한 칸의 수가 0인지 확인
* 3-1. 0이면 주사위 바닥 칸의 수를 복사
* 3-2. 0이 아니면 칸의 수를 주사위 바닥 면에 복사하고 칸의 수를 0으로 만들기
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static int[] dice;
	static int[][] map, deltas;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		dice = new int[6];
		deltas = new int[][] {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		tokens = new StringTokenizer(input.readLine());
		
		for(int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(tokens.nextToken());
			x += deltas[cmd][0];
			y += deltas[cmd][1];
			
			if(!isIn(x, y)) {
				x -= deltas[cmd][0];
				y -= deltas[cmd][1];
				continue;
			}

			if(cmd == 1) {
				move1();
			} else if(cmd == 2) {
				move2();
			} else if(cmd == 3) {
				move3();
			} else {
				move4();
			}
			
			if(map[x][y] == 0) {
				map[x][y] = dice[5];
			} else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			
			output.append(dice[0]).append("\n");
		}
		
		System.out.println(output);
	}
	
	static void move1() {
		int tmp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[5];
		dice[5] = dice[2];
		dice[2] = tmp;
	}
	
	static void move2() {
		int tmp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[5];
		dice[5] = dice[3];
		dice[3] = tmp;
	}
	
	static void move3() {
		int tmp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[5];
		dice[5] = dice[1];
		dice[1] = tmp;		
	}
	
	static void move4() {
		int tmp = dice[0];
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[4];
		dice[4] = tmp;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}