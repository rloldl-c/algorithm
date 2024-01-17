import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, ans;
	static char[] balls;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		balls = new char[N];
		ans = Integer.MAX_VALUE;
		
		String tmp = input.readLine();
		balls = tmp.toCharArray();
		
		int cnt = 0;
		char[] rightRed = copy();
		for(int i = N-1; i > 0; i--) {
			if(rightRed[i] == 'B' && rightRed[i-1] == 'R') {
				moveRight(rightRed, i-1);
				cnt++;
			}
		}
		
		ans = Integer.min(cnt, ans);
		
		char[] leftRed = copy();
		cnt = 0;
		for(int i = 0; i < N-1; i++) {
			if(leftRed[i] == 'B' && leftRed[i+1] == 'R') {
				moveLeft(leftRed, i+1);
				cnt++;
			}
		}
		
		ans = Integer.min(cnt, ans);
		
		char[] rightBlue = copy();
		cnt = 0;
		for(int i = N-1; i > 0; i--) {
			if(rightBlue[i] == 'R' && rightBlue[i-1] == 'B') {
				moveRight(rightBlue, i-1);
				cnt++;
			}
		}
		
		ans = Integer.min(cnt, ans);
		
		char[] leftBlue = copy();
		cnt = 0;
		for(int i = 0; i < N-1; i++) {
			if(leftBlue[i] == 'R' && leftBlue[i+1] == 'B') {
				moveLeft(leftBlue, i+1);
				cnt++;
			}
		}
		
		ans = Integer.min(cnt, ans);
		
		System.out.println(ans);

	}
	
	static void moveRight(char[] ballArr, int start) {
		for(int i = start; i < N-1; i++) {
			if(ballArr[i] != ballArr[i+1]) {
				char tmp = ballArr[i+1];
				ballArr[i+1] = ballArr[i];
				ballArr[i] = tmp;
			}
		}
	}
	
	static void moveLeft(char[] ballArr, int start) {
		for(int i = start; i > 0; i--) {
			if(ballArr[i] != ballArr[i-1]) {
				char tmp = ballArr[i-1];
				ballArr[i-1] = ballArr[i];
				ballArr[i] = tmp;
			}
		}
	}
	
	static char[] copy() {
		char[] res = new char[N];
		for(int i = 0; i < N; i++) {
			res[i] = balls[i];
		}
		
		return res;
	}
}