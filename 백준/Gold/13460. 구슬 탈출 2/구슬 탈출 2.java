import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int[][] deltas;

	public static void main(String[] args) throws IOException{
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		map = new char[N][M];
		visited = new boolean[11][11][11][11];
		deltas = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		// 처음 공들의 시작 위치
		int srr = 0;
		int src = 0;
		int sbr = 0;
		int sbc = 0;
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			String s = tokens.nextToken();
			for(int c = 0; c < M; c++) {
				map[r][c] = s.charAt(c);
				
				if(map[r][c] == 'R') {
					srr = r;
					src = c;
				}
				
				if(map[r][c] == 'B') {
					sbr = r;
					sbc = c;
				}
			}
		}
		
		int ans = bfs(srr, src, sbr, sbc);
		System.out.println(ans);
	}
	
	static int bfs(int srr, int src, int sbr, int sbc) {
		Deque<Pos> que = new ArrayDeque<>();
		que.offer(new Pos(srr, src, sbr, sbc, 0));
		visited[srr][src][sbr][sbc] = true;
		
		while(!que.isEmpty()) {
			Pos now = que.poll();
			
			// 현재 빨간 공이 있는 칸이 구멍이면 성공
			if(map[now.rr][now.rc] == 'O') return now.cnt;
			
			for(int d = 0; d < deltas.length; d++ ) {
				int nrr = now.rr;
				int nrc = now.rc;
				int nbr = now.br;
				int nbc = now.bc;
				int cnt = now.cnt;
				int redMove = 0;
				int blueMove = 0;

				// 빨간 공 움직이기
				// 현재가 구멍이 아니고, 다음칸이 벽이 아니면 이동
				while(map[nrr][nrc] != 'O' && map[nrr+deltas[d][0]][nrc+deltas[d][1]] != '#') {
					nrr += deltas[d][0];
					nrc += deltas[d][1];
					redMove++;
				}
				
				// 파란 공 움직이기
				while(map[nbr][nbc] != 'O' && map[nbr+deltas[d][0]][nbc+deltas[d][1]] != '#') {
					nbr += deltas[d][0];
					nbc += deltas[d][1];
					blueMove++;
				}
				
				// 파란 공이 구멍에 들어가면 continue
				if(map[nbr][nbc] == 'O') continue;
				
				// 빨간 공과 파란 공이 같은 위치에 있을 때
				if(nrr == nbr && nrc == nbc) {
					// 더 많은 칸을 이동한 공의 위치를 하나 전 칸으로 조정
					if(redMove > blueMove) {
						nrr -= deltas[d][0];
						nrc -= deltas[d][1];
					} else {
						nbr -= deltas[d][0];
						nbc -= deltas[d][1];						
					}
				}
				
				if(visited[nrr][nrc][nbr][nbc]) continue;
				
				// 이동 횟수가 10회 미만이면 더 이동
				if(cnt < 10) {
					visited[nrr][nrc][nbr][nbc] = true;
					que.offer((new Pos(nrr, nrc, nbr, nbc, cnt+1)));
				}
				
			}
		}
		
		return -1;
	}
	
	static class Pos {
		int rr;
		int rc;
		int br;
		int bc;
		int cnt;
		
		public Pos(int rr, int rc, int br, int bc, int cnt) {
			super();
			this.rr = rr;
			this.rc = rc;
			this.br = br;
			this.bc = bc;
			this.cnt = cnt;
		}
		
	}
}