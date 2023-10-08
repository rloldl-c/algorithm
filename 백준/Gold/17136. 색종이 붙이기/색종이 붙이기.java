/**
* @author 은비
* @since 2023-10-08
* @see https://www.acmicpc.net/problem/17136
* @performance
* @category #백트래킹
* @note 
* map을 순회하면서 1을 만나면 종이를 붙일 수 있는 칸인지 확인(rangeCheck)
* -> 종이 크기 내에 0이 있으면 종이를 붙이면 안됨
* 종이를 붙일 수 있으면 해당 범위에 있는 1을 0으로 바꾸고 다음 종이를 붙이러 재귀
* -> 재귀 횟수가 사용한 종이의 수가 됨
* 이때 어느 크기의 종이를 썼는지 체크해주기 위해 papers에서 해당 크기의 종이 개수를 하나 줄여주기
* 재귀를 돌면서 현재 저장한 최소값보다 depth가 커지면 더 이상 진행할 필요가 없으므로 return
* 현재 map에 1이 없으면 저장한 최소와 depth 중에 더 작은 값으로 갱신
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int ans;
	static int[] papers;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		papers = new int[] {5, 5, 5, 5, 5}; // 색종이 개수
		map = new int[10][10];
		ans = 26;
		
		for(int r = 0; r < 10; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 10; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		backtracking(0);
		
		System.out.println(ans == 26 ? -1 : ans);
	}
	
	static void backtracking(int depth) {
		// 현재 사용한 색종이가 이전에 저장한 최소값보다 크면 더 탐색할 필요 X
		if(depth > ans) {
			return;
		}
		
		// map에 1이 없으면 재귀 종료
		if(paperCheck()) {
			ans = Math.min(depth, ans);
			return;
		}
				
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				// 1이 적힌 칸을 만나면
				if(map[r][c] == 1) {
					for(int l = 4; l >= 0; l--) {
						// 현재 붙일 색종이를 사용할 수 있고, map의 범위를 벗어나지 않으며 중간에 0이 없으면
						if(papers[l] > 0 && isIn(r + l, c + l) && rangeCheck(r, c, l)) {
							// 색종이 개수를 하나 줄이고
							papers[l]--;
							// 1을 0으로 바꾸기
							change(r, c, l, 0);
							
							// 다음 범위를 탐색하러 재귀
							backtracking(depth+1);
							
							// 재귀에서 빠져나오면 붙인 종이를 떼어줘야하니까 1로 바꾸고
							change(r, c, l, 1);
							// 색종이 개수도 원래대로 바꿔놓기
							papers[l]++;
						}
					}
					
					// 5종류의 색종이를 모두 봤으면 더 이상 진행할 필요가 없음
					return;
				}
			}
		}
	}
	
	static boolean paperCheck() {
		for(int r = 0; r < 10; r++) {
			for(int c = 0; c < 10; c++) {
				if(map[r][c] == 1) return false;
			}
		}
		
		return true;
	}
	
	static void change(int r, int c, int l, int type) {
		for(int nr = r; nr <= r + l; nr++) {
			for(int nc = c; nc <= c + l; nc++ ) {
				map[nr][nc] = type;
			}
		}
	}
	
	static boolean rangeCheck(int r, int c, int l) {
		for(int nr = r; nr <= r + l; nr++) {
			for(int nc = c; nc <= c + l; nc++) {
				if(map[nr][nc] == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < 10 && c >= 0 && c < 10;
	}
}