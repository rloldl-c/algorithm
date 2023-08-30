import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, cnt, min;
	static ArrayList<Integer>[] map;
	static int[][] costArr, deltas;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		costArr = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		deltas = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				costArr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

        visited[0] = true;
		dfs(0, 0, 0);
		
		System.out.println(min);

	}

	static void dfs(int depth, int now, int cost) {
		if(depth == N-1) {
			if(costArr[now][0] == 0) {
				return;
			}
			
			cost += costArr[now][0];
			min = Math.min(cost, min);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] || costArr[now][i] == 0) {
				continue;
			}
			
			visited[i] = true;
			dfs(depth+1, i, cost + costArr[now][i]);
			visited[i] = false;
		}
	}
}