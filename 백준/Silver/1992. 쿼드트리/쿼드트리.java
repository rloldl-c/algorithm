/**
* @author 은비
* @since 2023-08-16
* @see https://www.acmicpc.net/problem/1992
* @performance
* @category #분할정복
* @note 
* 2차원 배열을 탐색하면서 다른 점이 나오는 구간은 4분할로 다시 탐색 -> 시작점과 범위를 줄여서 재귀
* 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서에 맞춰서 재귀를 탐색해야 함
* 압축하게 되는 경우 4개의 영역은 하나의 괄호에 묶여야 하므로 재귀 들어가기 전에 열린 괄호를 출력하고 재귀를 모두 마치면 닫힌 괄호를 출력
* 범위가 1이거나 현재 영역이 모두 같은 점이면 점만 출력해주면 됨
*/
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String s = input.readLine();
			for(int c = 0; c < N; c++) {
				map[r][c] = s.charAt(c) - '0';
			}
		}
		
		zip(0, 0, N);
		
		System.out.println(output);
	}
	
	private static void zip(int r, int c, int len) {
		if (len == 1) {
			output.append(map[r][c]);
			return;
		}

		for(int nr = r; nr < r+len; nr++) {
			for(int nc = c; nc < c+len; nc++) {
				if(map[r][c] != map[nr][nc]) {
					output.append("(");
					zip(r, c, len/2);
					zip(r, c+len/2, len/2);
					zip(r+len/2, c, len/2);
					zip(r+len/2, c+len/2, len/2);
					output.append(")");
					return;
				}
			}
		}
		
		output.append(map[r][c]);
	}

}