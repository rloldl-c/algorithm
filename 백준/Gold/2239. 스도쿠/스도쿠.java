/**
 * @author 은비
 * @since 2023-09-26
 * @see https://www.acmicpc.net/problem/2239
 * @performance 
 * @category #백트래킹
 * @note
 * 1~9까지 수를 한 칸씩 채워갔을 때 조건을 만족할 수 없는 칸이 생긴다 = 이전에 채웠던 칸에 잘못된 수를 채웠다
 * -> 이전 칸으로 돌아가서 잘못된 수를 지우고 다시 탐색해야함 = 백트래킹
 * 입력 받으면서 채워야 하는 빈칸의 개수를 리스트로 저장
 * 빈 칸을 모두 채웠으면 재귀 탈출
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static List<Pos> list;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		map = new int[9][9];
		list = new ArrayList<>(); // 빈 칸의 위치를 저장할 리스트
		
		for(int r = 0; r < 9; r++) {
			String s = input.readLine();
			for(int c = 0; c < 9; c++) {
				map[r][c] = s.charAt(c) - '0';
				if(map[r][c] == 0) {
					list.add(new Pos(r, c));
				}
			}
		}
		
		sudoku(0);

		System.out.println(output);
	}
	
	static void sudoku(int cnt) {
		// 빈 칸을 모두 탐색했으면 현재 스도쿠 정보를 출력
		// 1~9 순차적으로 채웠기 때문에 따로 정렬을 신경쓸 필요 X
		if(cnt == list.size()) {
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					output.append(map[r][c]);
				}
				
				output.append("\n");
			}
			
			flag = true;
			return;
		}
		
        if(!flag) {
		    Pos now = list.get(cnt);
		    int r = now.r;
		    int c = now.c;
		
			for(int i = 1; i < 10; i++) {
				// 1~9 중에서 현재 수 i가 같은 행, 열, 3x3 사각형에 있는지 확인
				if(rowCheck(r, c, i) && colCheck(r, c, i) && squareCheck(r, c, i)) {
					map[r][c] = i;
					sudoku(cnt+1);
					map[r][c] = 0;
				}
			}
		}
		
		return;
	}

	static boolean rowCheck(int r, int c, int num) {
		for(int nc = 0; nc < 9; nc++) {
			if(nc != c && map[r][nc] == num) return false;
		}
		
		return true;
	}
	
	static boolean colCheck(int r, int c, int num) {
		for(int nr = 0; nr < 9; nr++) {
			if(nr != r && map[nr][c] == num) return false;
		}
		
		return true;
	}
	
	static boolean squareCheck(int r, int c, int num) {
		for(int nr = (r/3) * 3; nr < (r/3) * 3 + 3; nr++) {
			for(int nc = (c/3) * 3; nc < (c/3) * 3 + 3; nc++) {
				if(nr != r && nc != c && map[nr][nc] == num) return false;
			}
		}
		
		return true;
	}
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
