/**
* @author 은비
* @since 2023-08-13
* @see https://www.acmicpc.net/problem/2578
* @performance
* @category #배열 #구현
* @note 
*/
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int bingo; // 빙고 수
	static int[] nums; // 사회자가 부른 수
	static int[][] map; // 빙고판
	
	public static void main(String[] args) throws IOException {
		map = new int[5][5];
		nums = new int[25];
		bingo = 0;
		boolean isBingo = false;

		for(int r = 0; r < 5; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 5; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r = 0; r < 5; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < 5; c++) {
				nums[r*5+c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i = 0; i < 25; i++) {
			for(int r = 0; r < 5; r++) {
				for(int c = 0; c < 5; c++) {
					if (map[r][c] == nums[i]) {
						map[r][c] = 0;
					}
					
					// 최소 12개의 수가 불려야 3빙고 가능
					if(i >= 11) {						
						bingo = 0;
						rowCheck();
						colCheck();
						crossCheck1();
						crossCheck2();
						
						if(bingo >= 3) {
							isBingo = true;
							output.append(i+1);
							break;
						}
					}
				}
				
				if(isBingo) {
					break;
				}
			}
			if(isBingo) {
				break;
			}
			
		}
		
		System.out.println(output);
	}

	static void rowCheck() {
		int cnt = 0;
		for(int r = 0; r < 5; r++) {
			cnt = 0;
			for(int c = 0; c < 5; c++) {
				if(map[r][c] == 0) {
					cnt++;
				}
			}
			
			if(cnt == 5) {
				bingo++;
			}
		}
	}
	
	static void colCheck() {
		int cnt = 0;
		
		for(int c = 0; c < 5; c++) {
			cnt = 0;
			for(int r = 0; r < 5; r++) {
				if(map[r][c] == 0) {
					cnt++;
				}
			}
			
			if(cnt == 5) {
				bingo++;
			}
		}
	}
	
	static void crossCheck1() {
		 int cnt = 0;
		 
		 for(int r = 0; r < 5; r++) {
			 if(map[r][r] == 0) {
				 cnt++;
			 }
		 }
		 
		 if(cnt == 5) {
			 bingo++;
		 }
	}

	static void crossCheck2() {
		int cnt = 0;
		
		for(int r = 0; r < 5; r++) {
			if(map[r][5-r-1] == 0) {
				cnt++;
			}
		}
		
		if(cnt == 5) {
			bingo++;
		}
	}
}