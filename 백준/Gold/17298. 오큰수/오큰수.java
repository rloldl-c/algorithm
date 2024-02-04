/* 스택
 * input [9, 5, 4, 8]
 * 1. 9일 때 
 * 	  	1-1. 스택: X
 * 		1-2. 스택에 9의 인덱스인 0 추가
 * 2. 5일 때 
 * 		2-1. 스택은 [0], 스택의 top과 5를 비교 -> input[0] = 9 > 5
 * 		2-2. 5의 인덱스인 1을 스택에 추가하고 넘어감
 * 3. 4일 때 
 * 		3-1. 스택은 [0, 1], 스택의 top과 4를 비교 -> input[1] = 5 > 4
 * 		3-1. 4의 인덱스인 2를 스택에 추가하고 넘어감
 * 4. 8일 때 
 * 		4-1. 스택은 [0, 1, 2], 스택의 top과 8을 비교 -> input[2] = 4 < 8
 * 		4-2. input[2]를 8로 바꾸고 스택 확인 [0, 1]
 * 		4-3. 스택이 비어있지 않으므로 현재 top과 8을 비교 -> input[1] = 5 < 8
 * 		4-4. input[1]을 8로 바꾸고 스택 확인 [0]
 * 		4-5. 스택이 비어있지 않으므로 현재 top과 8을 비교 -> input[0] = 9 > 8
 * 		4-6. 8의 인덱스인 3을 스택에 추가하고 넘어감
 * 5. N개의 수를 다 보면 스택엔 오른쪽에 큰 수가 없었던 수들이 남게 됨
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		int[] ans = new int[N];
		int[] nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				nums[stack.pop()] = nums[i];
			}
			
			stack.add(i);
		}
		
		while(!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}
		
		for(int n: nums) {
			output.append(n).append(" ");
		}
		
		System.out.println(output);
	}
}