import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, M;
	static boolean[][] connect;
	static boolean[] truePeople;
	static int[][] party;
	static Deque<Integer> que;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		connect = new boolean[N+1][N+1];
		
		// 진실을 아는 사람 입력 받기
		tokens = new StringTokenizer(input.readLine());
		int trueNum = Integer.parseInt(tokens.nextToken());
		truePeople = new boolean[N+1];
		que = new ArrayDeque<>();
		
		for(int i = 0; i < trueNum; i++) {
			int now = Integer.parseInt(tokens.nextToken());
			truePeople[now] = true;
			que.add(now);
		}
		
		// 파티 정보 입력 받기
		party = new int[M][];
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int m = Integer.parseInt(tokens.nextToken());
			party[i] = new int[m];
			
			for(int j = 0; j < m; j++) {
				party[i][j] = Integer.parseInt(tokens.nextToken());
			}
			
			// 양방향 그래프 만들어주기
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < m; k++) {
					if(j != k) {
						connect[party[i][j]][party[i][k]] = true;
					}
				}
			}
		}
		
		bfs();
		
		// 참여 가능한 파티 개수
		int cnt = 0;
		
		// 전체 파티 탐색
		for(int i = 0; i < M; i++) {
			// 현재 파티에 진실을 아는 사람이 있으면 true
			boolean flag = false;
			
			for(int j = 0; j < party[i].length; j++) {
				if(truePeople[party[i][j]]) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	// 진실을 알게 될 사람을 찾기 위한 bfs
	static void bfs() {
		boolean[] visited = new boolean[N+1];
		
		while(!que.isEmpty()) {
			int now = que.poll();
			visited[now] = true;
			truePeople[now] = true;
			
			for(int i = 0; i < N+1; i++) {
				if(!visited[i] && connect[now][i]) {
					truePeople[i] = true;
					que.add(i);
				}
			}
		}
	}
}