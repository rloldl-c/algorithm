/**
 * @author 은비
 * @since 2023-09-21
 * @see https://www.acmicpc.net/problem/3190
 * @performance 
 * @category #큐
 * @note
 * 뱀의 길이가 줄었다 늘었다 -> 큐로 맨 앞에 삽입시켜 길이를 늘려주거나 / 맨 앞에 삽입 시키고 뒤에서 하나 빼서 길이 유지
 */

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][] map, deltas, orders;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N+1][N+1];
		deltas = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
		map[1][1] = 1; // 뱀
		
		int K = Integer.parseInt(input.readLine());
		for(int i = 0; i < K; i++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			map[r][c] = 2; // 사과
		}
		
		int L = Integer.parseInt(input.readLine());
		orders = new int[L][2];
		for(int i = 0; i < L; i++) {
			tokens = new StringTokenizer(input.readLine());
			int t = Integer.parseInt(tokens.nextToken());
			char c = tokens.nextToken().toCharArray()[0];
			
			orders[i][0] = t;
			orders[i][1] = c == 'L' ? -1 : 1;
		}
		
		Deque<Pos> snake = new ArrayDeque<>();
		snake.offer(new Pos(1, 1)); // 맨 처음엔 맨위 맨좌측
		
		int d = 0; // 맨 처음엔 오른쪽 방향
		int idx = 0;
		int time = 1;
		while(true) {
			boolean end = false;
			Pos cur = snake.peek();
			// 다음 칸 위치
			int nr = cur.r + deltas[d][0];
			int nc = cur.c + deltas[d][1];
			
			// 방향 전환
			if(idx < orders.length && orders[idx][0] == time) {
				if(orders[idx][1] == -1) {
					if(d == 0) d = 3;
					else d--;
				} else {
					if(d == 3) d = 0;
					else d++;
				}
				idx++;
			}
			time++;
			
			// 다음 칸이 벽이면 게임 끝
			if(nr == 0 || nc == 0 || nr == N+1 || nc == N+1) {
				end = true;
				break;
			}
			
			for(Pos p: snake) {
				// 자신 몸과 부딪히면 게임 끝
				if(p.r == nr && p.c == nc) {
					end = true;
					break;
				}
			}
			
			if(end) break;
			
			snake.offerFirst(new Pos(nr, nc)); // 머리 다음 칸에 위치
			// 다음 칸에 사과가 있으면
			if(map[nr][nc] == 2) {
				map[nr][nc] = 0; // 사과 없어짐
			} else {
				snake.pollLast(); // 꼬리 옮김
			}
			
		}
		
		System.out.println(time-1);
	}

	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
}