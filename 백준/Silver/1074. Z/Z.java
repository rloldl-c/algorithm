/**
* @author 은비
* @since 2023-08-14
* @see https://www.acmicpc.net/problem/1074
* @performance
* @category #재귀
* @note 
* 탐색하는 구간 길이가 2가 될 때까지 길이를 줄여가면서 재귀 호출
* 재귀를 호출할 때도 z 순서에 따라 호출
* 길이가 2가 되면 0부터 1씩 늘려가면서 값 넣어주기
* -> 배열 만들면 메모리초과....
* 배열을 만들지 말고 값만 따로 저장하기
* -> 시간초과
* 구해야하는 좌표가 있는 사분면만 재귀 호출
* 다른 사분면도 순서를 고려해야 하므로 몇 칸을 지나왔는지 더해주기
*/
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, targetR, targetC, cnt, res;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		targetR = Integer.parseInt(tokens.nextToken());
		targetC = Integer.parseInt(tokens.nextToken());
		
		zSearch(0, 0, (int)Math.pow(2, N));
		
		System.out.println(res);
	}
	
	static void zSearch(int r, int c, int len) {
		if(len == 2) {
			if(r == targetR && c == targetC) {
				res = cnt;
			} else if(r == targetR && c+1 == targetC) {
				res = cnt+1;
			} else if(r+1 == targetR && c == targetC) {
				res = cnt+2;
			} else if(r+1 == targetR && c+1 == targetC) {
				res = cnt+3;
			}
			return;
		}
		
		for(int nr = r; nr < r + len; nr++) {
			for(int nc = c; nc < c + len; nc++) {
				if(nr + len/2 > targetR && nc + len/2 > targetC) {
					zSearch(nr, nc, len/2);
				} else if(nr + len/2 > targetR && nc + len > targetC) {
					cnt += (int)Math.pow(len/2, 2);
					zSearch(nr, nc+len/2, len/2);
				} else if(nr + len > targetR && nc + len/2 > targetC) {
					cnt += (int)Math.pow(len/2, 2) * 2;
					zSearch(nr+len/2, nc, len/2);
				} else if(nr + len > targetR && nc + len > targetC) {
					cnt += (int)Math.pow(len/2, 2) * 3;
					zSearch(nr+len/2, nc+len/2, len/2);
				}
				
				return;
			}
		}
	}
}