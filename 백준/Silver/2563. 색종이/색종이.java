/**
* @author 은비
* @since 2023-08-09
* @see https://www.acmicpc.net/problem/2563
* @performance
* @category #
* @note 
* 101 X 101 2차원 배열을 만들고
* 입력으로 들어오는 수 r, c를 시작 좌표로 생각해서
* (r, c) ~ (r+10, c+10)까지를 1로 표시
* 모든 입력을 받고 난 후에 1인 칸의 개수를 세서 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] paper = new int[101][101];
		int N = Integer.parseInt(input.readLine());
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken());
			int c = Integer.parseInt(tokens.nextToken());
			
			for(int nr = r; nr < r+10; nr++) {
				for(int nc = c; nc < c+10; nc++) {
					paper[nr][nc] = 1;
				}
			}
			
		}

		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				if(paper[r][c] == 1) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

}
