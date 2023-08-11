/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/15686
* @performance
* @category #완전탐색 #조합
* @note 
* 최대 13개의 치킨 집 중에서 M개를 뽑아야 함 -> 조합
* 새로운 조합이 나올 때마다 치킨 거리를 구해줌
* 각 집에서 치킨 거리도 여러 개의 치킨 집 중에서 치킨 거리가 제일 작은 걸 선택해야 함
* 도시의 치킨 거리를 새로 구할 때마다 최소값을 갱신
*/
import java.io.*;
import java.util.*;

class Pos {
	int r;
	int c;
	
	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, min;
	static int[][] map;
	static ArrayList<Pos> allChicken, allHouse;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		allChicken = new ArrayList<Pos>();
		allHouse = new ArrayList<Pos>();
		map = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		
		for(int r = 1; r <= N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
				
				if(map[r][c] == 2) {
					allChicken.add(new Pos(r, c));
				} else if(map[r][c] == 1) {
					allHouse.add(new Pos(r, c));					
				}
			}
		}
		
		combi(0, 0, new int[M]);
		
		System.out.println(min);
		
	}
	
	static void combi(int cnt, int start, int[] chicken) {
		if(cnt == M) {
			calDistance(chicken);
			return;
		}
		
		for(int i = start; i < allChicken.size(); i++) {
			chicken[cnt] = i;
			combi(cnt+1, i+1, chicken);
		}
	}
	
	static void calDistance(int[] chicken) {
		// 도시의 치킨 거리
		int total = 0;
		
        // 도시의 모든 집에서 각 치킨 집마다의 치킨 거리를 구해주고 그 중에서 최소값을 선택해서 total에 더해줌
		for(int i = 0; i < allHouse.size(); i++) {
			// 각 집의 여러 개의 치킨 거리 중 최소값을 저장할 변수
			int now = Integer.MAX_VALUE;
			Pos hp = allHouse.get(i);
			
			for(int j = 0; j < chicken.length; j++) {
				Pos cp = allChicken.get(chicken[j]);
				now = Math.min(now, Math.abs(cp.r - hp.r) + Math.abs(cp.c - hp.c));
			}

			total += now;
		}

		min = Math.min(total, min);
	}

}
