/**
* @author 은비
* @since 2023-10-10
* @see
* @performance
* @category #
* @note 
* 자석들을 회전시켜가며 비교하면 비교하는 날이 자꾸 변하니까
* 원래 상태에서 비교하고 회전하는 방향을 따로 저장해주자
* 
* 회전 시키는 자석 기준 왼쪽은 i번째 자석의 6번 날과 i-1번째 2번 날을 비교
* 회전 시키는 자석 기준 오른쪽은 i번째 자석의 2번 날과 i+1번째 6번 날을 비교
* 
* 다르면 현재 i번째 자석을 회전시키는 방향과 반대 방향을 저장하고
* 같은 극이 나오면 그 다음 자석들도 회전하면 안됨
* 
* 회전할 때는 원소 8개짜리 임시 배열을 만들어놓고
* 앞뒤로 복사하는 방식으로 회전시켜주기
*/

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] magnet;
	static int[] dir;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		magnet = new int[4][8]; // 4개의 자석과 각각의 날 정보 저장
		dir = new int[4]; // 4개의 자석이 회전할 방향 저장
		
		for(int t = 0; t < T; t++) {
			output.append("#").append(t+1).append(" ");
			int K = Integer.parseInt(input.readLine());
			
			for(int i = 0; i < 4; i++) {
				tokens = new StringTokenizer(input.readLine());
				
				for(int j = 0; j < 8; j++) {
					// i번 자석의 j번 날 정보 입력 받기
					magnet[i][j] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			for(int k = 0; k < K; k++) {
				// 이전에 있던 정보 없애기
				Arrays.fill(dir, 0);
				
				tokens = new StringTokenizer(input.readLine());
				int num = Integer.parseInt(tokens.nextToken()) - 1;
				int d = Integer.parseInt(tokens.nextToken());
				
				dir[num] = d;
				setDir(num);
				
				for(int i = 0; i < 4; i++) {
					if(dir[i] == 1) {
						turnRight(i);
					} else if(dir[i] == -1) {
						turnLeft(i);
					}
				}
			}
			
			int ans = 0;
			for(int i = 0; i < 4; i++) {
				if(magnet[i][0] == 1) {
					ans += Math.pow(2, i);
				}
			}
			
			output.append(ans).append("\n");
		}

		System.out.println(output);
	}
	
	static void setDir(int num) {
		// 회전 시키는 자석 왼쪽
		for(int i = num; i > 0; i--) {
			if(magnet[i][6] != magnet[i-1][2]) {
				dir[i-1] = dir[i] * (-1);
			} else {
				break;
			}
		}
		
		// 회전 시키는 자석 오른쪽
		for(int i = num; i < 3; i++) {
			if(magnet[i][2] != magnet[i+1][6]) {
				dir[i + 1] = dir[i] * (-1);
			} else {
				break;
			}
		}
	}

	// 시계방향
	// 뒤에 있는 걸 앞으로 가져오고 맨 앞 자리에는 맨 뒤 원소가 위치
	static void turnRight(int num) {
		int[] tmp = new int[8];
		tmp[0] = magnet[num][7];

		for(int i = 1; i < 8; i++) {
			tmp[i] = magnet[num][i-1];
		}
		
		for(int i = 0; i < 8; i++) {
			magnet[num][i] = tmp[i];
		}
	}
	
	// 반시계방향
	// 앞에 있는 걸 뒤로 가져가고 맨 뒤 자리에는 맨 앞 원소가 위치
	static void turnLeft(int num) {
		int[] tmp = new int[8];
		tmp[7] = magnet[num][0];
		
		for(int i = 0; i < 7; i++) {
			tmp[i] = magnet[num][i+1];
		}
		
		for(int i = 0; i < 8; i++) {
			magnet[num][i] = tmp[i];
		}
	}
}