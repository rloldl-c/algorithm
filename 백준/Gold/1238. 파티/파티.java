import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		X = Integer.parseInt(tokens.nextToken());
		List<Node>[] list = new ArrayList[N+1]; // 출발지 K에서 도착지 X로 갈 때 사용할 리스트
		List<Node>[] revList = new ArrayList[N+1]; // 출발지 X에서 도착지 K로 갈 때 사용할 리스트
		PriorityQueue<Node> que = new PriorityQueue<>();
		int[] dist = new int[N+1];
		int[] revDist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(revDist, Integer.MAX_VALUE);
		
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			revList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			int weight = Integer.parseInt(tokens.nextToken());
			list[start].add(new Node(end, weight));
			revList[end].add(new Node(start, weight));
		}
		
		dist = dijkstra(list);
		revDist = dijkstra(revList);
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist[i] + revDist[i]);
		}
		
		System.out.println(ans);

	}
	
	static int[] dijkstra(List<Node>[] list) {
		PriorityQueue<Node> que = new PriorityQueue<>();
		que.offer(new Node(X, 0));
		
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		boolean[] visited = new boolean[N+1];
		
		while(!que.isEmpty()) {
			Node nowNode = que.poll();
			int now = nowNode.next;
			
			if(visited[now]) continue;
			
			visited[now] = true;
			for(Node node: list[now]) {
				if(!visited[node.next] && dist[node.next] > dist[now] + node.weight) {
					dist[node.next] = dist[now] + node.weight;
					que.offer(new Node(node.next, dist[node.next]));
				}
			}
		}
		
		return dist;
	}
	
	static class Node implements Comparable<Node> { 
		int next;
		int weight;
		
		public Node(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
}