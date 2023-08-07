import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[][] nums = new int[N][M];
		int ans = -1;
		
		for(int r = 0; r < N; r++) {
			String line = input.readLine();
			
			for(int c = 0; c < M; c++) {
				nums[r][c] = line.charAt(c) - '0';
			}
		}
		
		for(int r = 0; r  < N; r++) {
			for(int c = 0; c < M; c++) {
				for(int i = -N; i < N; i++) {
					for(int j = -M; j < M; j++) {
						if(i == 0 && j == 0) {
							continue;
						}
						
						int nr = r;
						int nc = c;
						int now = 0;
						
						while (nr >= 0 && nr < N && nc >= 0 && nc < M) {
							now *= 10;
							now += nums[nr][nc];
							
							if(isSquare(now)) {
								ans = Math.max(ans, now);
							}
							
							nr += i;
							nc += j;
						}
						
						if(isSquare(now)) {
							ans = Math.max(ans, now);
						}
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static boolean isSquare(int n) {
		int sqrt = (int)Math.sqrt(n);
		
		return sqrt*sqrt == n;
	}

}
