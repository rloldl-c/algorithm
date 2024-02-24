import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int target = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		// 일단 +/- 버튼으로 이동하는 횟수를 최소 횟수로 생각
		int min = Math.abs(target - 100);
		
		// 고장난 버튼 true
		boolean[] button = new boolean[10];
		
		if(M != 0) {
			tokens = new StringTokenizer(input.readLine());
			
			for(int i = 0; i < M; i++) {
				button[Integer.parseInt(tokens.nextToken())] = true;
			}
		}
		
		// 0번부터 999999번까지
		for(int i = 0; i <= 999999; i++) {
			String now = String.valueOf(i);
			int len = now.length();
			
			// 현재 번호에 고장난 버튼이 포함되어 있으면 false
			boolean flag = true;
			
			for(int j = 0; j < len; j++) {
				if(button[now.charAt(j) - '0']) {
					flag = false;
					break;
				}
			}
			
			// 버튼으로 현재 채널(i)로 이동할 수 있다면
			if(flag) {
				// 번호로 i번까지 이동하는 횟수 len
				// 이동한 i번과 목표 채널의 차이를 합하면 목표 채널로 이동하는 횟수를 구할 수 있음
				int cnt = len + Math.abs(target - i);
				min = Integer.min(min, cnt);
			}
		}
		
		System.out.println(min);
		
	}
}