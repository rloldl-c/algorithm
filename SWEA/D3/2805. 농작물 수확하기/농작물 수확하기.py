import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 은비
 * @since 2023-08-01
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB
 * @performance
 * @category #배열
 * @note N = 7일 때
 * 1번 행은 밭 크기의 절반에 해당하는 좌표(N/2)만  포함
 * 2번 행은 N/2-1에서 N/2+1까지 포함
 * 3번 행은 N/2-2에서 N/2+2까지 포함
 * 4번 행은 N/2-3에서 N/2+3까지 포함
 * --------------------------------------- N/2 구간이 지나면 1~3을 거꾸로 반복
 * 5번 행은 N/2-2에서 N/2+2까지 포함
 * 6번 행은 N/2-1에서 N/2+1까지 포함
 * 7번 행은 N/2만 포함
 * -> N/2로 시작헤서 tmp로 범위 조절하기
 * -> 1번 ~ N/2까지는 행이 넘어갈 때마다 tmp를 하나씩 늘려가면서 빼주고 더하기
 * -> N/2 ~ N까지는 행이 넘어갈 때마다 tmp를 하나씩 줄여가면서 빼주고 더하기
 */

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(input.readLine());
			int[][] farm = new int[N][N];
			int ans = 0;
			int tmp = N / 2;
			
			for(int r = 0; r < N; r++) {
				String val = input.readLine();

				for(int c = 0; c < N; c++) {
					farm[r][c] = val.charAt(c) - '0';
				}
			}
			
			for(int r = 0; r < N; r++) {
				if(r < N / 2 + 1) {
					for(int c = tmp; c < N - tmp; c++) {
						ans += farm[r][c];
					}
					
					tmp--;
				} else {
					++tmp;
					
					for(int c = tmp + 1; c < N - tmp - 1; c++) {
						ans += farm[r][c];
					}
					
				}
			}
			output.append("#").append(t+1).append(" ").append(ans).append("\n");
		}

		System.out.println(output);
	}

}
