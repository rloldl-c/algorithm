import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static String[][] map;
	static ArrayList<Pos> teachers, obstrac;
	static boolean[][] visited;
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean ans;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		map = new String[N][N];
		teachers = new ArrayList<>();
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = tokens.nextToken();
				
				if(map[i][j].equals("T")) {
					teachers.add(new Pos(i, j));
				}
			}
		}
		
		backtracking(0);
		
		System.out.println(ans ? "YES" : "NO");

	}
	
	private static void backtracking(int cnt) {
		if(cnt == 3) {
			if(monitoring()) {
				ans = true;
			}
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].equals("X")) {
					map[i][j] = "O";
					backtracking(cnt+1);
					map[i][j] = "X";
					
				}
			}
		}
		
	}
	
	private static boolean monitoring() {	
		for(Pos now: teachers) {					
			int r = now.r;
			int c = now.c;
			
			for(int i = 0; i < 4; i++) {
				int nr = r + deltas[i][0];
				int nc = c + deltas[i][1];
				
				while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc].equals("O")) {
						break;
					}
					
					if(map[nr][nc].equals("S")) {
						return false;
					}
					
					nr += deltas[i][0];
					nc += deltas[i][1];
				}
			}
		}
		
		return true;
	}
	
	static class Pos {
		int r;
		int c;
		
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}