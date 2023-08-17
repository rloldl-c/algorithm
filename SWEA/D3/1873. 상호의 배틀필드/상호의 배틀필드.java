import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C, nr, nc, d, deltas[][];
	static char[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
							//  위      아래     왼      오른
		deltas = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		
		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			R = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			map = new char[R][C];
			int[] start = new int[2];
			d = 0;
			
			for(int r = 0; r < R; r++) {
				String s = input.readLine();
				for(int c = 0; c < C; c++) {
					map[r][c] = s.charAt(c);

					if("^v<>".indexOf(s.charAt(c)) > -1) {
						nr = r;
						nc = c;
						
						if(map[r][c] == '^') {
							d = 0;
						} else if (map[r][c] == 'v') {
							d = 1;
						} else if (map[r][c] == '<') {
							d = 2;
						} else {
							d = 3;
						}
					}
				}
			}
			
			int N = Integer.parseInt(input.readLine());
			String s = input.readLine();
			
			for(int i = 0; i < N; i++) {
				if(s.charAt(i) == 'S') {
					int sr = nr + deltas[d][0];
					int sc = nc + deltas[d][1];
					
					// 범위 밖으로 나갈 때까지 반복
					while(isIn(sr, sc)) {
						// 벽돌이면 부수고 폭탄도 소멸
						if(map[sr][sc] == '*') {
							map[sr][sc] = '.';
							break;
						}
						
						// 강철이면 폭탄만 소멸
						if(map[sr][sc] == '#') {
							break;
						}
						
						sr += deltas[d][0];
						sc += deltas[d][1];
					}
					
				} else {
					if(isIn(nr, nc)) {						
						map[nr][nc] = '.';
						
						switch (s.charAt(i)) {
						case 'U':
							d = 0;
							move(nr, nc);
							break;
							
						case 'D':
							d = 1;
							move(nr, nc);
							break;
							
						case 'L':
							d = 2;
							move(nr, nc);
							break;
							
						case 'R':
							d = 3;
							move(nr, nc);
							break;
						}
					}
				}
			}
			
			output.append("#").append(t+1).append(" ");
			
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					output.append(map[r][c]);
				}
				
				output.append("\n");
			}
		}
		
		System.out.println(output);
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
	
	static void move(int r, int c) {
		int tmpR = r + deltas[d][0];
		int tmpC = c + deltas[d][1];

		switch (d) {
		case 0:
			map[nr][nc] = '^';
			break;
			
		case 1:
			map[nr][nc] = 'v';
			break;
			
		case 2:
			map[nr][nc] = '<';
			break;
			
		case 3:
			map[nr][nc] = '>';
			break;
		}
		
		if(!isIn(tmpR, tmpC) || map[tmpR][tmpC] != '.') {
			return;
		}

		char tmp = map[nr][nc];
		map[nr][nc] = '.';
		nr = tmpR;
		nc = tmpC;
		map[nr][nc] = tmp;
	}

}