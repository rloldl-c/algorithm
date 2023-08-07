/**
* @author 은비
* @since 2023-08-07
* @see https://www.acmicpc.net/problem/1158
* @performance
* @category #큐
* @note 
* 1~N까지 큐에 저장
* while로 큐가 다 빌 때까지 반복
* idx 변수로 제거해야 할 번호 관리
* while 순회하면서 idx가 K 배수가 되면 스택에서 pop
* K 배수가 아니라면 큐 맨 위에 있는 번호를 맨 아래로 보내기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		ArrayDeque<Integer> que = new ArrayDeque<>();
		int idx = 1;
		
		for(int i = 0; i < N; i++) {
			que.add(i+1);
		}
		
		output.append("<");
		
		while(!que.isEmpty()) {
			if(idx % K == 0) {
				if (que.size() == 1) {					
					output.append(que.poll());
				} else {					
					output.append(que.poll()).append(", ");
				}
			} else {
				que.offer(que.poll());
			}
			
			idx++;
		}
		
		output.append(">");
		System.out.println(output);
	
	}

}
