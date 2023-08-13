/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/11724
* @performance
* @category #그래프
* @note 
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, cnt, graph[][];
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int start) {
		visited[start] = true;
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i] && graph[start][i] == 1) {
				dfs(i);
			}
		}
	}

}