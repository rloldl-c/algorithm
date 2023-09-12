/**
* @author 은비
* @since 2023-09-10
* @see 
* @performance
* @category # 그리디?
* @note 
* 입력 최대값이 100,000이라 완탐으로는 풀이 불가
* 최소 횟수 => 그리디?
* 맨 처음(0번째) 전구의 상태를 바꿀 수 있는 스위치 : 0번 스위치, 1번 스위치
* 0번 스위치를 누르냐 / 누르지 않냐 에 따라 1번 스위치를 누르냐 /누르지 않냐를 선택해야 함
* -> 0번 스위치를 눌렀을 경우 / 누르지 않았을 경우 로 나눠서 두 번을 탐색..?
* 현재 번호 스위치 상태와 결과 스위치 상태가 다르다고 현재 번호 스위치를 누르면 이전 스위치 상태도 변함
* ex) 현재 000 결과 010 일 때, 1번 스위치 상태가 다르다고 1번 스위치를 누르면 111로 0번 스위치 상태까지 달라짐
* 그래서 1번 스위치 상태가 다르면 1번이 아닌 2번 스위치를 눌러야 함
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		int[] res = new int[N];
		int[] status1 = new int[N]; // 맨 처음 스위치를 안 누르고 체크
		int[] status2 = new int[N]; // 맨 처음 스위치를 누르고 체크
		int cnt1 = 0;
		int cnt2 = 1; // 맨 처음 스위치를 눌렀으므로 1부터 시작
		int ans = Integer.MAX_VALUE;
		
		String s = input.readLine();
		for(int i = 0; i < N; i++) {
			status1[i] = s.charAt(i) - '0';
			status2[i] = s.charAt(i) - '0';
		}

		s = input.readLine();
		for(int i = 0; i < N; i++) {
			res[i] = s.charAt(i) - '0';
		}
		
		for(int i = 1; i < N; i++) {
			if(status1[i-1] != res[i-1]) {
				pushSwitch(i, status1);
				cnt1++;
			}
		}
		
		if(equal(status1, res)) {
			ans = Math.min(ans, cnt1);
		}
		
        pushSwitch(0, status2); // 맨 처음 스위치 눌러주기
		
		for(int i = 1; i < N; i++) {
			if(status2[i-1] != res[i-1]) {
				pushSwitch(i, status2);
				cnt2++;
			}
		}
		
		if(equal(status2, res)) {
			ans = Math.min(ans, cnt2);
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}
	
	static void pushSwitch(int n, int[] status) {
		if(n == 0) {
			for(int i = 0; i < 2; i++) {				
				status[i] = toggle(status[i]);
			}
		} else {
			for(int i = n-1; i <= n+1; i++) {
				if(i < N) {					
					status[i] = toggle(status[i]);
				}
			}
		}
	}
	
	static int toggle(int n) {
		return 1 - n;
	}
	
	static boolean equal(int[] status, int[] origin) {
		for(int i = 0; i < N; i++) {
			if(status[i] != origin[i]) {
				return false;
			}
		}
		
		return true;
	}

}