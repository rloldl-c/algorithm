import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, d, k, c, cnt;
	static int[] belt, check;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken()); // 벨트에 있는 초밥 수
		d = Integer.parseInt(tokens.nextToken()); // 초밥 종류 수
		k = Integer.parseInt(tokens.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(tokens.nextToken()); // 쿠폰
		belt = new int[N*2]; // 회전해야하므로 배열 두개를 붙여서 생각
		check = new int[30001]; // 초밥의 전체 종류
		check[c] = 1; // 쿠폰은 무조건 하나 먹는다고 생각하기
		cnt = 1;
		
		int[] tmp = new int[N];
		for(int i = 0; i < N; i++) {
			tmp[i] = Integer.parseInt(input.readLine());
			belt[i] = tmp[i];
		}
		
		for(int i = N, idx = 0; i < 2*N; i++, idx++) {
			belt[i] = tmp[idx];
		}
				
		for(int i = 0; i < k; i++) {
			check[belt[i]] += 1;
			if(check[belt[i]] == 1) {
				cnt++;
			}
		}
		
		int max = cnt;
		int start = 1;
		int end = k;
		
		while(start < 2*N-k-1) {		
			check[belt[start-1]] -= 1;
			if(check[belt[start-1]] == 0) {				
				cnt--;
			}
			
			check[belt[end]] += 1;
			if(check[belt[end]] == 1) {
				cnt++;
			}
			
			start++;
			end++;
			max = Math.max(cnt, max);
			
			if(cnt == d) {
				break;
			}
		}
		
		System.out.println(max);
	}

}