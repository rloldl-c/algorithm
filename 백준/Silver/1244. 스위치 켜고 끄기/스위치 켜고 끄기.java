/**
 * @author 은비
 * @since 2023-08-01
 * @see https://www.acmicpc.net/problem/1244
 * @performance
 * @category #구현
 * @note
 * <남학생>
 * 스위치 번호가 자신 수의 배수이면 스위치 상태 바꾸기
 * 
 * <여학생>
 * 자기가 받은 수와 같은 번호의 스위치 상태가 좌우 대칭
 * + 가장 많은 스위치를 포함하는 구간 찾기
 * + 해당 구간에 스위치 상태 모두 바꾸기
 * (대칭인 구간이 없으면 자신의 스위치만 상태 바꾸기)
 * -> 자신 번호는 무조건 바꿔줌
 * -> 처음엔 자신 번호-1 부터 자신 번호 +1를 비교하고 대칭이면 -2 ~ +2까지 비교, 대칭이면 -3 ~ +3 비교...를 반복
 * -> 반복하면서 대칭이면 바로바로 스위치 상태 바꿔주기
 * -> 반복 중에 대칭이 아닌 지점이 나오면 반복 종료
 * 
 * 한 줄에 20개씩 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] status;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		status = new int[N+1];
		tokens = new StringTokenizer(input.readLine());
		
		for(int i = 1; i <= N; i++) {
			status[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int stu = Integer.parseInt(input.readLine());
		
		for(int i = 1; i <= stu; i++) {
			tokens = new StringTokenizer(input.readLine());
			int gender = Integer.parseInt(tokens.nextToken());
			int num = Integer.parseInt(tokens.nextToken());
			
			if(gender == 1) {
				for(int j = 1; j <= N; j++) {
					if(j % num == 0) {
						toggle(j);
					}
				}				
			} else {
				toggle(num);
				
				int start = num-1;
				int end = num+1;
				
				while(true) {
					if(start < 1 || end > N) {
						break;
					}
					
					if(status[start] == status[end]) {
						toggle(start);
						toggle(end);
					} else {
						break;
					}
					
					start--;
					end++;
				}				
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(i == N) {				
				output.append(status[i]);
			} else if (i % 20 == 0) {
				output.append(status[i]).append("\n");				
			} else {
				output.append(status[i]).append(" ");
			}
		}
		
		System.out.println(output);

	}
	
	public static void toggle(int num) {
		if(status[num] == 0) {
			status[num] = 1;
		} else {
			status[num] = 0;
		}
	}
}

