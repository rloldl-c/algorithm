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
		oper = new int[4];
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
			oper[i] = Integer.parseInt(tokens.nextToken());
		}

		calc(0, nums[0]);
		
		output.append(max).append("\n").append(min);
		System.out.println(output);

	}
	
	private static void calc(int idx, int res) {
		if(idx == N-1) {
			min = Math.min(min, res);
			max = Math.max(max, res);
		}
		
		idx++;
		
		if(oper[0] > 0) {
			oper[0]--;
			calc(idx, res+nums[idx]);
			oper[0]++;
		}
		
		if(oper[1] > 0) {
			oper[1]--;
			calc(idx, res-nums[idx]);
			oper[1]++;
		}
		
		if(oper[2] > 0) {
			oper[2]--;
			calc(idx, res*nums[idx]);
			oper[2]++;
		}
		
		if(oper[3] > 0) {
			oper[3]--;
			calc(idx, res/nums[idx]);
			oper[3]++;
		}
	}
}