import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[] indegree = new int[N+1]; // 진입 차수를 표시하기 위한 배열
		ArrayList<Integer>[] lst = new ArrayList[N+1]; // 방향 그래프를 입력받기 위한 리스트
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i = 0; i <= N; i++) {
			lst[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int J = Integer.parseInt(tokens.nextToken());
			int pre = 0;
			for(int j = 0; j < J; j++) {
				int now = Integer.parseInt(tokens.nextToken());
				// 맨 처음으로 입력되는 가수 번호를 제외하기 위한 if문
				if(pre != 0) {					
					lst[pre].add(now);
					indegree[now]++;
				}
				pre = now;
			}
		}
		
		Deque<Integer> que = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			// 진입 차수가 0인 가수들 que에 넣기
			if(indegree[i] == 0) {
				que.offer(i);
			}
		}
		
		// bfs
		while(!que.isEmpty()) {
			int now = que.poll();
			res.add(now);

			for(int i = 0; i < lst[now].size(); i++) {
				int next = lst[now].get(i);
				if(--indegree[next] == 0) {
					que.offer(next);
				}
			}
		}
		
		// 결과 리스트에 모든 가수가 들어왔다 = 모든 가수들의 순서를 정할 수 있다는 의미로 리스트 출력
		// 없는 가수가 있다 = 사이클이 존재해 모든 가수들의 순서를 정할 수 없다는 의미로 0을 출력
		if(res.size() == N) {
			for(int i: res) {
				output.append(i + "\n");
			}
			
			System.out.println(output);
		} else {
			System.out.println(0);
		}
	}
}