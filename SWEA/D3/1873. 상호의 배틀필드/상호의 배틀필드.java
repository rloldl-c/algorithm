/**
* @author 은비
* @since 2023-08-17
* @see 
* @performance 
* @category #구현
* @note 
* 문제 조건대로만 구현하면 됨
* 동작이 UDLR일 때는 방향만 다를 뿐 행동은 같으니 1차로 S일 때와 아닐 때로 나누기
* S는 범위를 벗어나기 전까지 반복해야하니 while로 작성
* -> 폭탄이 움직일 뿐 차가 움직이는 것은 아님! 임시 변수로 폭탄 위치를 나타내자
* UDLR인 경우 차의 방향은 범위를 벗어나도 바뀌어야 하므로 d와 현재 위치에서 모양을 바꿔줘야 함
* 그리고 현재 이동에서 한 칸 움직일 수 있으면 이동
* -> 이때 지나온 길은 .으로 바꿔줘야 함
*/
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
							map[nr][nc] = '^';
							move(nr, nc);
							break;
							
						case 'D':
							d = 1;
							map[nr][nc] = 'v';
							move(nr, nc);
							break;
							
						case 'L':
							d = 2;
							map[nr][nc] = '<';
							move(nr, nc);
							break;
							
						case 'R':
							d = 3;
							map[nr][nc] = '>';
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