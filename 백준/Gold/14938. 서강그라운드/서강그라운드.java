import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, m, r;
	static ArrayList<Integer>[] graph;
	static int[] items;
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		n = Integer.parseInt(tokens.nextToken());
		m = Integer.parseInt(tokens.nextToken());
		r = Integer.parseInt(tokens.nextToken());
		items = new int[n+1];
		graph = new ArrayList[n+1];
		dist = new int[n+1][n+1];

		tokens = new StringTokenizer(input.readLine());
		for(int i = 1; i < n+1; i++) {
			items[i] = Integer.parseInt(tokens.nextToken());
			graph[i] = new ArrayList<>();
		}

		for(int i = 0; i < r; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			int l = Integer.parseInt(tokens.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
			dist[a][b] = l;
			dist[b][a] = l;
		}
		
		int ans = 0;
		for(int i = 1; i < n+1; i++) {
			int[] visited = new int[n+1];
			for(int j = 1; j < n+1; j++) {
				visited[j] = -1;
			}
			visited[i] = Integer.MAX_VALUE;
			ans = Integer.max(dfs(m, i, items[i], visited), ans);
		}

		System.out.println(ans);
	}
	
	private static int dfs(int max, int now, int cnt, int[] visited) {
		for(int next: graph[now]) {
			if(dist[now][next] <= max && (visited[next] < max - dist[now][next])) {
				
				if(visited[next] == -1) {
					visited[next] = max - dist[now][next];
					cnt += dfs(max - dist[now][next], next, items[next], visited);
				} else {
					visited[next] = max - dist[now][next];
					cnt += dfs(max - dist[now][next], next, 0, visited);
					
				}
			}
		}
			
			
		return cnt;
	}
}