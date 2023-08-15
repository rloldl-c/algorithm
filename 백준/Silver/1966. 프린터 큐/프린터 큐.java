/**
* @author 은비
* @since 2023-08-16
* @see https://www.acmicpc.net/problem/1966
* @performance
* @category #큐
* @note 
* 찾는 값이 큐에서 최대값이고 가장 최상단에 있을 때까지 로직 반복
* M(인덱스)과 큐의 최대값을 변수에 저장하고
* 큐의 최상단이 최대값일 때와 아닐 때 나누어서 로직 진행
* --------- 큐의 최상단이 최대값일 때 ---------
* 인덱스 값이 0인지 확인하고 0이면 반복 종료
* 0이 아니면 pop 해주고, 인쇄했으니 인쇄 횟수 변수에 1 더하기
* 최대값을 pop해서 현재 큐에서 다시 최대값 찾아야함
* --------- 큐의 최상단이 최대값이 아닐 때 ---------
* 최상단 값을 맨 뒤로 보내주고 그에 맞게 인덱스 조정해주기
*/

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int N = Integer.parseInt(tokens.nextToken());
			int M = Integer.parseInt(tokens.nextToken());
			Deque<Integer> que = new ArrayDeque<>();
			int max = 0; // 가장 높은 중요도
			int cnt = 1; // 몇 번째로 인쇄되는지
			int idx = M; // 몇 번째에 있는지
			
			tokens = new StringTokenizer(input.readLine());
			for(int i = 0; i < N; i++) {
				int tmp = Integer.parseInt(tokens.nextToken());
				que.offer(tmp);
				
				if(max < tmp) max = tmp;
			}
			
			while(!que.isEmpty()) {
				if(que.peek() == max) {
					if(0 == idx) {
						break;
					}

					que.poll();
					idx--;
					cnt++;
					max = 0;
					
					for(int i = 0; i < que.size(); i++) {
						int tmp = que.poll();
						if(max < tmp) max = tmp;
						que.offer(tmp);
					}
					
				} else {
					int tmp = que.poll();
					que.offer(tmp);
					
					if(idx == 0) {
						idx = que.size()-1;
					} else {
						idx--;
					}
				}
			}
			
			output.append(cnt).append("\n");
		}

		System.out.println(output);
	}

}