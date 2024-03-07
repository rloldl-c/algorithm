import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] ladder, snakes, visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		
		ladder = new int[101];
		visited = new int[101];
		
		for(int i = 0; i < N+M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			
			ladder[start] = end;
		}
		
		bfs();
		
		System.out.println(visited[100]);
	}
	
	static void bfs() {
		Deque<Integer> que = new ArrayDeque<>();
		que.add(1);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			int cnt = visited[now];
			
			for(int i = 1; i < 7; i++) {
				int next = now + i;
				
				if(next == 100) {
					visited[next] = cnt+1;
					return;
				}
				
				// 다른 칸으로 이동하는 사다리(뱀)이 있으면 그 칸으로 이동
				if(ladder[next] != 0) {
					next = ladder[next];
				}
				
				if(visited[next] == 0) {
					visited[next] = cnt+1;
					que.add(next);
				} 
			}
		}
	}
}