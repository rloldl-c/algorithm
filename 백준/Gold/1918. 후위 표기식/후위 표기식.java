import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		String str = input.readLine();
		Deque<Character> stack = new ArrayDeque<>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				stack.push(c);
			} else if(c == ')') {
				while(!stack.isEmpty()) {
					char now = stack.pop();
					
					if(now == '(' ) {
						break;
					}
					
					output.append(now);
				}
			} else if("+-*/".indexOf(c) > -1) {
				if(stack.isEmpty()) {
					stack.push(c);
				} else {
					while(!stack.isEmpty()) {
						// 스택의 우선순위가 더 낮거나 괄호를 만나면 break
						if(((c == '*' || c == '/') && (stack.peek() == '-' || stack.peek() == '+')) || stack.peek() == '(') {
							break;
						}
						
						output.append(stack.pop());
					}
					
					stack.push(c);
				}
			} else {
				output.append(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			output.append(stack.pop());
		}
		
		System.out.println(output);
		
	}
}