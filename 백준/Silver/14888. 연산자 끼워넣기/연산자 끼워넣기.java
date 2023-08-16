import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, min, max, nums[], oper[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		nums = new int[N];
		oper = new int[N-1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		tokens = new StringTokenizer(input.readLine());
		int idx = 0;
		// 0: 덧셈 1: 뺄셈 2: 곱셈 3: 나눗셈
		for(int i = 0; i < 4; i++) {
			int tmp = Integer.parseInt(tokens.nextToken());
			
			for(int j = 0; j < tmp; j++) {
				oper[idx] = i;
				idx++;
			}
		}

		per(0, new boolean[N-1], new int[N-1]);
		
		output.append(max).append("\n").append(min);
		System.out.println(output);

	}
	
	private static void per(int cnt, boolean[] visited, int[] order) {
		if(cnt == N-1) {
			calc(order);
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if(!visited[i]) {
				order[cnt] = oper[i];
				visited[i] = true;
				per(cnt+1, visited, order);
				visited[i] = false;
			}
		}
	}
	
	private static void calc(int[] order) {
		int tmp = nums[0];
		
		for(int i = 0; i < N-1; i++) {
			int left = nums[i+1];

			// 더하기
			if(order[i] == 0) {
				tmp += left;
			} else if(order[i] == 1) { // 뺄셈
				tmp -= left;
			} else if(order[i] == 2) { // 곱셈
				tmp *= left;
			} else {
				if(tmp < 0) {
					tmp *= (-1);
					tmp /= left;
					tmp *= (-1);
				} else {
					tmp /= left;
				}
			}
		}
		
		max = Math.max(max, tmp);
		min = Math.min(min, tmp);
	}
}