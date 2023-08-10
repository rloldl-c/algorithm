/**
* @author 은비
* @since 2023-08-11
* @see
* @performance
* @category # 조합
* @note 
* A 음식을 만들 수 있는 재료들을 저장한 N/2개의 원소를 가진 배열 생성
* A에서 사용하지 않은 재료들을 저장한 B 배열 생성
* A와 B에 사용할 재료는 N개의 재료 중에서 N/2개를 선택할 수 있는 조합으로 구함
* 현재 조합에 포함된 원소(visited 배열에서 true인 인덱스)를 A에 사용할 재료, 
* 포함되지 않은 원소(visited 배열에서 false인 인덱스)를 B에 사용할 재료라고 판단
* 조합으로 재료가 정해졌으면 이중 for문으로 각각의 시너지 계산해서 최소값 찾기
*/

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, min, food[][];

	public static void main(String[] args) throws NumberFormatException, IOException {	
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(input.readLine());
			min = Integer.MAX_VALUE;
			food = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				tokens = new StringTokenizer(input.readLine());
				for(int c = 0; c < N; c++) {
					food[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			
			combi(0, 0, new boolean[N]);
			
			output.append("#").append(t+1).append(" ").append(min).append("\n");
		}
		
		System.out.println(output);
	}
	
	static void combi(int cnt, int start, boolean[] visited) {
		if(cnt == N/2) {
			calSynergy(visited);
			return;
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			combi(cnt+1, i+1, visited);
			visited[i] = false;
		}
	}

	static void calSynergy(boolean[] visited) {
		int synergyA = 0;
		int synergyB = 0;
		
		for(int i = 0; i < N-1; i++) {
			for(int j = i+1; j < N; j++) {
				if(visited[i] && visited[j]) {
					synergyA += food[i][j] + food[j][i];
				} else if(!visited[i] && !visited[j]) {
					synergyB += food[i][j] + food[j][i];
				}
			}
		}
		
		min = Math.min(Math.abs(synergyA - synergyB), min);
	}
}
