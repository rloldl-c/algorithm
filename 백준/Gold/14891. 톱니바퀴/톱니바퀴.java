/**
* @author 은비
* @since 2023-10-03
* @see https://www.acmicpc.net/problem/14891
* @performance
* @category #
* @note 
* 0: N극, 1: S극
* 1: 시계방향, -1: 반시계방향
* 서로 맞닿은 극(2번 - 6번)이 다르면 옆에 있는 톱니바퀴도 회전
* 모두 한 번에 회전하니까 회전한 결과를 바로바로 반영하면 안됨 -> 회전 전/후를 다른 배열에 저장
* 한 바퀴가 회전하면 회전한 방향에 맞춰서 다음 회전 방향은 반대로 바꿔주기
* -> 회전 방향도 바로바로 바꿔주면 왼쪽 오른쪽에 다른 방향이 적용됨
* 입력으로 주어지는 방향과 초기 톱니바퀴 상태에서 회전할 바퀴들만 따로 배열에 저장
* 회전하는 톱니바퀴의 양 옆을 비교해가면서 회전시키기
* 만약 같은 극이라 회전하지 않는다면 옆에 톱니바퀴가 있더라도 회전을 계속하면 안됨
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static char[][] wheels, newWheels;

	public static void main(String[] args) throws IOException {
		wheels = new char[5][8]; // 기존 톱니바퀴 배열
		newWheels = new char[5][8]; // 회전한 결과를 저장할 배열
		for(int i = 1; i < 5; i++) {
			wheels[i] = input.readLine().toCharArray();
			for(int j = 0; j < 8; j++) {
				newWheels[i][j] = wheels[i][j];
			}
		}
		
		int K = Integer.parseInt(input.readLine());
		
		for(int k = 0; k < K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int[] d = new int[5]; // 회전 방향을 저장할 배열
			d[n] = Integer.parseInt(tokens.nextToken());
			
			// 회전시킨 바퀴 왼쪽
			for(int i = n-1; i >= 1; i--) {
				if(wheels[i+1][6] != wheels[i][2]) {
					d[i] = d[i+1] * (-1);
				} else {
					break;
				}
			}
			
			// 회전시킨 바퀴 오른쪽
			for(int i = n+1; i <= 4; i++) {
				if(wheels[i-1][2] != wheels[i][6]) {
					d[i] = d[i-1] * (-1);
				} else {
					break;
				}
			}
			
			for(int i = 1; i < 5; i++) {
				if(d[i] == 1) {
					rotateRight(i);
				} else if(d[i] == -1) {
					rotateLeft(i);
				}
			}

			// 회전한 톱니바퀴를 현재 톱니바퀴로 옮기기
			for(int i = 1; i < 5; i++) {
				for(int j = 0; j < 8; j++) {
					wheels[i][j] = newWheels[i][j];
				}
			}

		}

		int ans = 0;
		for(int i = 1; i < 5; i++) {
			if(wheels[i][0] == '1') {
				ans += Math.pow(2, i-1);
			}
		}
		
		System.out.println(ans);
	}
	
	// 반시계
	static void rotateLeft(int n) {
		newWheels[n][7] = wheels[n][0];
		
		for(int i = 1; i < 8; i++) {
			newWheels[n][i-1] = wheels[n][i];
		}
	}
	
	// 시계
	static void rotateRight(int n) {
		newWheels[n][0] = wheels[n][7];
		
		for(int i = 0; i < 7; i++) {
			newWheels[n][i+1] = wheels[n][i];
		}
	}
}