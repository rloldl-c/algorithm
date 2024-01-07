import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
	static StringTokenizer tokens;
	static int N, K;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		belt = new int[2 * N];
		robot = new boolean[2 * N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < 2 * N; i++) {
			belt[i] = Integer.parseInt(tokens.nextToken());
		}
		
		moveBelt();
	}
	
	private static void moveBelt() {
		int ans = 0;
		
		while(!isEnd()) {
			// 1. 로봇과 벨트 회전
			int tmp = belt[2 * N - 1];
			for(int i = 2 * N -1; i > 0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = tmp;

			for(int i = 2 * N - 1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			robot[N - 1] = false; // N번 칸 로봇 내리기
			
			// 2. 로봇 이동
			for(int i = 2 * N - 1; i > 0; i--) {
				// 현재 칸에 로봇이 있고, 이동하려는 칸에 로봇이 없고, 칸의 내구도가 1 이상
				if(robot[i-1] && !robot[i] && belt[i] > 0) {
					// 이동하면 칸의 내구도 -1
					belt[i]--;
					robot[i] = true;
					robot[i-1] = false;
				}
			}
			
			robot[N-1] = false; // N번 칸 로봇 내리기
			
			// 3. 로봇 올리기
			if(belt[0] > 0) {
				robot[0] = true;
				belt[0]--;
			}
			
			ans++;
		}
		
		System.out.println(ans);
	}
	
	private static boolean isEnd() {
		int cnt = 0;
		
		for(int i = 0; i < 2 * N; i++) {
			if(belt[i] == 0) {
				cnt++;
			}
		}
		
		if(cnt >= K) {
			return true;
		}
		
		return false;
	}
}