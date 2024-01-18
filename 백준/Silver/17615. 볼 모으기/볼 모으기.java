import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
        int ans = 0;
		char[] balls = new char[N];
		ans = Integer.MAX_VALUE;
		
		String tmp = input.readLine();
		balls = tmp.toCharArray();
		
		int red = 0;
		int blue = 0;
		boolean prevRed = false;
		boolean prevBlue = false;
		
		// 파란색 공 오른쪽으로 모으기	
		for(int i = N-1; i >= 0; i--) {
			if(!prevRed && balls[i] == 'R') {
				prevRed = true;
			}
			
			if(prevRed && balls[i] == 'B') {
				blue++;
			}
		}
		
		// 빨간색 공 오른쪽으로 모으기
		for(int i = N-1; i >= 0; i--) {
			if(!prevBlue && balls[i] == 'B') {
				prevBlue = true;
			}
			
			if(prevBlue && balls[i] == 'R') {
				red++;
			}
		}
		
		ans = Integer.min(red, blue);
		
		red = 0;
		blue = 0;
		prevRed = false;
		prevBlue = false;
		
		// 파란색 공 왼쪽으로 모으기
		for(int i = 0; i < N; i++) {
			if(!prevRed && balls[i] == 'R') {
				prevRed = true;
			}
			
			if(prevRed && balls[i] == 'B') {
				blue++;
			}
		}
		
		// 빨간색 공 왼쪽으로 모으기
		for(int i = 0; i < N; i++) {
			if(!prevBlue && balls[i] == 'B') {
				prevBlue = true;
			}
			
			if(prevBlue && balls[i] == 'R') {
				red++;
			}
		}

		System.out.println(Integer.min(Integer.min(red, blue), ans));
	}
}