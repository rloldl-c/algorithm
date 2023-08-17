/**
* @author 은비
* @since 2023-08-16
* @see https://www.acmicpc.net/problem/3109
* @performance
* @category #dfs
* @note 
* 첫번째 열의 모든 지점에서 출발
* 시작점에서 dfs 탐색 시작
* 가장 많은 파이프 개수 -> 마지막 열의 맨 위부터 쌓아야 함
* -> 방향을 오른쪽위, 오른쪽, 오른쪽아래 순서로 탐색
* 이미 지나온 길은 다시 갈 수 없음 -> 탐색하면서 갈 수 없는 'x'로 표시
* 갈 수 있으면 계속 가다가 마지막 열에 도달하면 파이프 수에 하나 더해줌
* 만약 3방향 모두를 살폈을 때 갈 수 있는 길이 없다면 return으로 빠져나오기
*/

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, cnt, deltas[][];
	static char map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		map = new char[R][C];
		deltas = new int[][] {{-1, 1}, {0, 1}, {1, 1}};
		
		for(int r = 0; r < R; r++) {
			String s = input.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			dfs(r, 0);
		}

		System.out.println(cnt);
	}
	
	private static boolean dfs(int r, int c) {
		if(c == C-1) {
			cnt++;
			return true;
		}

		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
				map[nr][nc] = 'x';
				if(dfs(nr, nc)) return true;
			}
		}
		
		return false;
	}
}