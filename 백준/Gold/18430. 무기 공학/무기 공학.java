import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][] dx = {{0, 1}, {-1, 0}, {0, 1}, {-1, 0}};
	static int[][] dy = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int N, M, ans;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 크기가 작아서 부메랑을 하나도 만들 수 없는 경우
		if(N < 2 || M < 2) {
			System.out.println(0);
			return;
		}
		
		makeBoomerang(0, 0, 0);
		
		System.out.println(ans);
	}
	
	static void makeBoomerang(int x, int y, int total) {
		if(y == M) {
			y = 0;
			x++;
		}
		
		if(x == N) {
			ans = Integer.max(ans, total);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx1 = x + dx[i][0];
			int ny1 = y + dy[i][0];
			int nx2 = x + dx[i][1];
			int ny2 = y + dy[i][1];
			
			if(!visited[x][y] && isIn(nx1, ny1) && isIn(nx2, ny2) && !visited[nx1][ny1] && !visited[nx2][ny2]) {
				visited[x][y] = true;
				visited[nx1][ny1] = true;
				visited[nx2][ny2] = true;
				int power = map[x][y]*2 + map[nx1][ny1] + map[nx2][ny2];
				makeBoomerang(x, y+1, total+power);
				visited[x][y] = false;
				visited[nx1][ny1] = false;
				visited[nx2][ny2] = false;
			}
		}
		
		makeBoomerang(x, y+1, total);
	}
	
	static boolean isIn(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}