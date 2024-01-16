import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, ans;
	static int[][] map;
	static int[][] deltas = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	// 서 남 동 북 방향, {1, 1, 2, 2, 7, 7, 10, 10, 5, a} 순서
	static int[][] dx = {{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, 
							{0, 0, 1, 1, 1, 1, 2, 2, 3, 2}, 
							{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, 
							{0, 0, -1, -1, -1, -1, -2, -2, -3, -2}};
	static int[][] dy = {{0, 0, -1, -1, -1, -1, -2, -2, -3, -2}, 
							{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, 
							{0, 0, 1, 1, 1, 1, 2, 2, 3, 2}, 
							{-1, 1, -2, 2,-1, 1, -1, 1, 0, 0}};
	static int[] percent = {1, 1, 2, 2, 7, 7, 10, 10, 5};

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j]= Integer.parseInt(tokens.nextToken()); 
			}
		}
		
		tonado(N / 2, N / 2);
		System.out.println(ans);
	}
	
	static void tonado(int r, int c) {
		int cnt = 1;
		
		while(true) {
			int d = 0;
			
			while(d < 4) {
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < cnt; j++) {
						int nr = r + deltas[d][0];
						int nc = c + deltas[d][1];

						if(nr < 0 || nc < 0) return;
						
						// 움직인 칸에 모래가 있으면 모래 이동
						if(map[nr][nc] != 0 ) {
							moveSand(r, c, map[nr][nc], d);
							map[nr][nc]= 0; 
						}
						
						r = nr;
						c = nc;
					}
					
					d++;
				}
				
				cnt++;
			}
		}
	}
	
	static void moveSand(int r, int c, int initAmount, int d) {
		int total = initAmount;
		
		for(int i = 0; i < 9; i++) {
			int nr = r + dx[d][i];
			int nc = c + dy[d][i];
			int amount = (initAmount * percent[i]) / 100;
			
			// 모래가 격자 밖으로 이동하면 count
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				ans += amount;
			} else { // 아니면 해당 칸에 더해주기
				map[nr][nc] += amount; 
			}
			
			total -= amount;
		}
		
		int nr = r + dx[d][9];
		int nc = c + dy[d][9];
		
		if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
			ans += total;
		} else {
			map[nr][nc] += total;
		}
	}

}