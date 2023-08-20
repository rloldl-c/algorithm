import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new int[N][M];
		
		// 입력으로 주어지는 직사각형 입력 받기
		for(int r = 0; r < N; r++) {
			String string = input.readLine();
			for(int c = 0; c < M; c++) {
				map[r][c] = string.charAt(c) - '0';
			}
		}
		
		// 정사각형을 만들 수 있는 가장 큰 수 찾기
		int len = Math.min(N, M);
		
		// 정사각형을 만들고 꼭짓점을 확인하는 메서드 호출
		square(len);
		
		System.out.println(ans*ans);
	}
	
	// 정사각형 만들기
	static void square(int len) {
		// 정사각형의 길이가 1이면 꼭짓점 수가 같은 큰 정사각형이 없다는 뜻 -> 1 출력
		if(len == 1) {
			ans = 1;
			return;
		}
		
		// 현재 정사각형의 길이에서 만들 수 있는 모든 정사각형을 탐색
		for(int r = 0; r < N-len+1; r++) {
			for(int c = 0; c < M-len+1; c++) {
				// 현재 정사각형의 모든 꼭짓점이 같은 수인지 확인
				// 모두 같은 수면 현재 정사각형의 길이를 출력하고 메서드 종료
				if(map[r+len-1][c] == map[r][c] && map[r][c+len-1] == map[r][c] && map[r+len-1][c+len-1] == map[r][c]) {
					ans = len;
					return;
				}
			}
		}
		
		// 현재 길이에서 꼭짓점이 모두 같은 정사각형이 없었다면 길이를 줄여서 다시 탐색
		square(len-1);
	}

}