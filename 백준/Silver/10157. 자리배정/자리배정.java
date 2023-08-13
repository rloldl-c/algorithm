import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int C = Integer.parseInt(tokens.nextToken());
		int R = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(input.readLine());
		int[][] map = new int[R][C];
		int[][] deltas = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int d = 0;
		
		if(K > C * R) {
			System.out.println(0);
		} else {
			int r = R;
			int c = 0;
			int num = 1;
			
			while(num <= R * C) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr >= R || nr < 0 || nc >= C || nc < 0 || map[nr][nc] != 0) {
					if(d == 3) {
						d = 0;
					} else {
						d++;
					}
					
					continue;
				}

				if(num == K) {
					output.append(nc+1).append(" ").append(R - nr);
					break;
				}

				map[nr][nc] = num++;
				r = nr;
				c = nc;

			}

			System.out.println(output);
		}
	}

}