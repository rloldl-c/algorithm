import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, max;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		result = new int[N][9];
		max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		int[] order = new int[8];
		for(int i = 0; i < 8; i++) {
			order[i] = i+2;
		}
		
		do {
			int[] tmp = new int[9];
			for(int i = 0; i < 8; i++) {
				if(i > 2) {
					tmp[i+1] = order[i];
				} else {
					tmp[i] = order[i];					
				}
			}
			
			// 4번 타자는 1번 선수로 고정
			tmp[3] = 1;

			game(tmp);
		} while (np(order));
		
		System.out.println(max);
	}
	
	static void game(int[] order) {
		int idx = 0; // 타자 번호
		int score = 0;
		
		// 총 N이닝
		for(int n = 0; n < N; n++) {
			// 0 홈 1 1루 2 2루 3 3루
			boolean[] ground = new boolean[4];
			int out = 0;
			
			// 9번 선수가 공을 쳐도 3아웃이 나오지 않으면 이닝은 끝나지 않음
			while(true) {
				// 3아웃인지 아닌지 판단할 변수
				boolean flag = true;
				
				// 이전 이닝에서 마지막 타자 다음 번호 선수부터 시작
				for(int i = idx; i < 9; i++) {
					// 이번 이닝에서 각 타자의 결과
					switch (result[n][order[i]-1]) {
					// 아웃
					case 0:
						out++;
						break;
					// 안타
					case 1:
						for(int j = 3; j >= 0; j--) {
							if(ground[j]) {
								if(j == 3) {
									ground[j] = false;
									score++;
									continue;
								}
								
								ground[j] = false; // 현재 루에선 나가고
								ground[j+1] = true; // 다음 루로 진루
							}
						}
						ground[1] = true; // 타자가 1루로 진루
						break;
					// 2루타
					case 2:
						for(int j = 3; j >= 0; j--) {
							if(ground[j]) {
								if(j == 3 || j == 2) {
									ground[j] = false;
									score++;
									continue;
								}
								
								ground[j] = false; // 현재 루에선 나가고
								ground[j+2] = true; // 두루씩 진루
							}
						}
						ground[2] = true; // 타자가 2루로 진루
						
						break;
					// 3루타
					case 3:
						for(int j = 3; j >= 0; j--) {
							if(ground[j]) {
								ground[j] = false;
								score++;
							}
						}
						ground[3] = true; // 타자가 1루로 진루
						break;
					// 홈런
					case 4:
						// 모든 주자 홈까지 진루
						for(int j = 3; j >= 0; j--) {
							if(ground[j]) {
								ground[j] = false;
								score++;
							}
						}
						score++; // 타자까지 홈으로 진루
						break;
						
					}
					
					// 한 이닝에 아웃이 3개가 넘으면 타순을 유지한채로 다음 이닝으로 넘어감
					if(out >= 3) {
						idx = i+1;
						// 마지막 선수에서 끝나면 다음 선수는 1번 선수가 됨
						if(idx == 9) {
							idx = 0;
						}
						
						flag = false;
						break;
					}
					
					
				}
				
				if(!flag) {
					break;
				}
				// 9번까지 왔을 때 3아웃이 발생하지 않으면 1번 타자가 다시 타석으로
				idx = 0;				
			}
		}
		
		max = Math.max(max, score);
	}
	
	static boolean np(int[] order) {
		int lastPeak = order.length-1;
		while(lastPeak > 0 && order[lastPeak-1] >= order[lastPeak]) {
			lastPeak--;
		}
		
		if(lastPeak == 0) return false;
		
		int nextPeak = order.length-1;
		
		while(order[lastPeak-1] >= order[nextPeak]) {
			nextPeak--;
		}
		
		swap(order, lastPeak-1, nextPeak);
		
		for(int left = lastPeak, right = order.length-1; left < right; left++, right--) {
			swap(order, left, right);
		}
		
		return true;
	}
	
	static void swap(int[] order, int a, int b) {
		int tmp = order[a];
		order[a] = order[b];
		order[b] = tmp;
	}
}