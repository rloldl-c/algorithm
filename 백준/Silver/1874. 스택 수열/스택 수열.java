/**
* @author 은비
* @since 2023-08-13
* @see https://www.acmicpc.net/problem/1874
* @performance
* @category #스택
* @note 
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static Stack<Integer> stack;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		stack = new Stack<>();
		boolean flag = true;
		int num = 1;
		
		for(int i = 1; i <= N; i++) {
			int now = Integer.parseInt(input.readLine());
			
			if(stack.isEmpty()) {
				stack.push(num++);
				output.append("+\n");
			}	
			
			if(stack.peek() > now) {
				flag = false;
				break;
			}
			
			while (stack.peek() < now) {
				stack.push(num++);
				output.append("+\n");
			}

			if(stack.peek() == now) {
				stack.pop();
				output.append("-\n");
			}
		}
		
		if(!flag || !stack.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(output);
		}

	}

}