import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, P, X;
	static int[][] digits;
	
	public static void main(String[] args) throws IOException {
		digits = new int[][] {
				{1, 1, 1, 1, 1, 1, 0}, // 0
				{0, 1, 1, 0, 0, 0, 0}, // 1
				{1, 1, 0, 1, 1, 0, 1}, // 2
				{1, 1, 1, 1, 0, 0, 1}, // 3
				{0, 1, 1, 0, 0, 1, 1}, // 4
				{1, 0, 1, 1, 0, 1, 1}, // 5
				{1, 0, 1, 1, 1, 1, 1}, // 6
				{1, 1, 1, 0, 0, 0, 0}, // 7
				{1, 1, 1, 1, 1, 1, 1}, // 8
				{1, 1, 1, 1, 0, 1, 1} // 9
		};
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 최대 층 높이
		K = Integer.parseInt(tokens.nextToken()); // 표현되는 자리수
		P = Integer.parseInt(tokens.nextToken()); // 반전시킬 최대 led
		X = Integer.parseInt(tokens.nextToken()); // 현재 층
		int ans = 0;

		// 현재 층 디지털로 표현
		int[][] nowDigit = convertDigit(X);
		int[][] newDigist = new int[K][7];
		int cnt = 0;
		
		// 1층부터 N층까지 최대 P개를 반전시켜서 만들 수 있는 층인지 확인
		for(int n = 1; n <= N; n++) {
			if(n == X) continue;
			// 비교할 층을 디지털로 표현
			newDigist = convertDigit(n);
			cnt = countLED(nowDigit, newDigist);
			if(cnt >= 1 && cnt <= P) { 
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int countLED(int[][] originNum, int[][] newNum) {
		int count = 0;
		
		for(int k = 0; k < K; k++) {
			for(int i = 0; i < 7; i++) {
				if(originNum[k][i] != newNum[k][i]) {
					count++;
				}
			}
		}
        
		return count;
	}
	
	public static int[][] convertDigit(int num) {
		int[][] res = new int[K][7];
		
		for(int k = K-1; k >= 0; k--) {
			int tmp = num % 10;
			num /= 10;
			
			for(int i = 0; i < 7; i++) {
				res[k][i] = digits[tmp][i];
			}
		}
		
		return res;
	}
}