import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, ans, cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 0);
			visited[i] = false;
			
			if(ans == 1) {
				break;
			}
		}
		
		System.out.println(ans);
	}

	static void dfs(int v, int depth) {
		if(depth == 4) {
			ans = 1;
			return;
		}

		for(int i = 0; i < graph[v].size(); i++) {
			int next = graph[v].get(i);
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;
			}
		}
	}
}