/**
 * @author 은비
 * @since 2023-08-03
 * @see https://www.acmicpc.net/problem/2630
 * @performance
 * @category #재귀
 * @note
 * 처음에는 전체 길이만큼 같은 색인지 탐색
 * 중간에 색이 다른 부분이 있으면 이전에 탐색한 길이의 1/2만큼 탐색
 * 탐색하는 길이가 줄었으므로 다음 탐색은 총 4번 해줘야 함
 * 여기서도 중간에 색이 다른 부분이 있으면 탐색하는 길이를 절반으로 줄여서 다시 탐색
 * 탐색하는 영역이 모두 같은 색이거나 탐색하는 길이가 1이 될 때까지 반복
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, blue, white, paper[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		paper = new int[N][N];
		blue = 0;
		white = 0;

		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				paper[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		colorCheck(0, 0, N, paper[0][0]);

		output.append(white).append("\n").append(blue);
		System.out.println(output);
		
	}
	
	static void colorCheck(int r, int c, int l, int color) {
		if(l == 1) {
			colorPlus(color);
			return;
		}
		
		for(int nr = r; nr < r + l; nr++) {
			for(int nc = c; nc < c + l; nc++) {
				if(paper[nr][nc] != color) {
					colorCheck(r, c, l/2, paper[r][c]);
					colorCheck(r, c+l/2, l/2, paper[r][c+l/2]);
					colorCheck(r+l/2, c, l/2, paper[r+l/2][c]);
					colorCheck(r+l/2, c+l/2, l/2, paper[r+l/2][c+l/2]);
					return;
				}
			}
		}
		
		colorPlus(color);
		return;
	}
	
	static void colorPlus(int color) {
		if(color == 0) {
			white++;
		} else {
			blue++;
		}
		
		return;
	}

}
