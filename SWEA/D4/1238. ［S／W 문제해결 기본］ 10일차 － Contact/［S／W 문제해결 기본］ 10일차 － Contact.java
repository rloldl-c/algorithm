/**
* @author 은비
* @since 2023-08-23
* @see 
* @performance
* @category #BFS
* @note 
* 동시에 연락이 가능해야 함 -> bfs
* 인원별로 몇 번째에 연락을 받는지 기록하기 위해 int형 배열을 하나 선언
* bfs를 탐색하면서 몇 번째 연락인지를 확인하기 위해 depth 변수 활용
*/

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, start;
	static int[] order;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		int T = 10;
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			start = Integer.parseInt(tokens.nextToken());
			graph = new ArrayList[101]; // 연락 인원은 최대 100
			order = new int[101]; // 몇 번째 연락인지를 기록
			tokens = new StringTokenizer(input.readLine());
			
			for(int i = 0; i < graph.length; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				
				graph[from].add(to);
			}
			
			bfs(start);
			
			int cnt = 0;
			int num = 0;
			
			for(int i =1; i <= 100; i++) {
				// 연락을 받은 인원 중에
				if(order[i] != 0) {
					// 가장 많은 연락을 받아야 하고
					if(order[i] >= cnt) {
						cnt = order[i];
						// 그 중에서도 가장 큰 번호를 가지고 있는 사람
						if(i > num) {
							num = i;
						}
					}
				}
			}
			
			output.append("#").append(t+1).append(" ").append(num).append("\n");
		}
		
		System.out.println(output);
	}
	
	// depth 체크 -> que.size?
	static void bfs(int start) {
		boolean[] visited = new boolean[101];
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(start);
		visited[start] = true;
		int depth = 1;
		
		while(!que.isEmpty()) {
			// depth 체크를 위한 큐 size를 따로 저장
			int size = que.size();

			// 현재 depth의 원소만을 탐색하기 위해 size가 0이 될 때까지만 반복
			while(--size >= 0) {
				int now = que.poll();
				visited[now] = true;
				
				if(graph[now].size() > 0) {
					for(int i = 0; i < graph[now].size(); i++) {
						int next = graph[now].get(i);
						if(!visited[next]) {
							visited[next] = true;
							// 연락을 받을 수 있는 사람이라면 현재 depth 기록
							order[next] = depth;
							que.offer(next);
						}
					}
				}
			}
			
			depth++;
		}
	}
}