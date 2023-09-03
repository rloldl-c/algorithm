import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int V = Integer.parseInt(tokens.nextToken());
		int E = Integer.parseInt(tokens.nextToken());
		List<Node>[] list = new ArrayList[V+1];
		PriorityQueue<Node> que = new PriorityQueue<>();
		int[] D = new int[V+1];
		int start = Integer.parseInt(input.readLine());
		
		for(int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			tokens = new StringTokenizer(input.readLine());
			int u = Integer.parseInt(tokens.nextToken());
			int v = Integer.parseInt(tokens.nextToken());
			int w = Integer.parseInt(tokens.nextToken());
			list[u].add(new Node(v, w));
		}
		
		Arrays.fill(D, Integer.MAX_VALUE); // 최단 경로 테이블 최대값으로 초기화
		D[start] = 0;
		que.add(new Node(start, 0));
		boolean[] visited = new boolean[V+1];
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			int n = now.next;
			
			if(visited[n]) continue;
			
			visited[n] = true;
			
			for(Node node: list[n]) {
				if(D[node.next] > D[n] + node.w) {
					D[node.next] = D[n] + node.w;
					que.add(new Node(node.next, D[node.next]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(D[i] == Integer.MAX_VALUE) {
				output.append("INF");
			} else {
				output.append(D[i]);
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	static class Node implements Comparable<Node> {
		int next;
		int w;
		
		public Node(int next, int w) {
			super();
			this.next = next;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}