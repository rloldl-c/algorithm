/**
* @author 은비
* @since 2023-08-23
* @see https://www.acmicpc.net/problem/17471
* @performance
* @category #BFS #부분조합
* @note 
* 원소를 1개 이상 ~ N-1개 이하로 가지고 있는 부분집합을 모두 구하기
* -> 이 부분집합에 속한 원소끼리 하나의 선거구, 속하지 않은 원소끼리 하나의 선거구를 이루고 있는 것
* 부분 집합을 새로 구할 때마다 각각의 선거구에 속한 지역들이 서로 연결되어있는지 bfs 탐색으로 확인
* 
* <bfs 탐색>
* 같은 선거구인 곳만 탐색해야 하므로 시작점이 어느 선거구에 속했는지를 매개변수로 전달
* bfs 탐색 종료 후, 같은 선거구인데 방문하지 않은 지점이 있으면 안됨
* -> boolean을 반환하여 연결된 지역들인지를 판단
* 
* 두 선거구에 속한 지역들이 모두 연결된 지역들이라면 인구수를 계산하여 차이가 최소인지 판단하고 최소값 갱신
*/
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ans;
	static int[] amount; // 인구수 저장
	static ArrayList<Integer>[] all; // 인접한 구역 정보를 인접 리스트로 저장
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(input.readLine());
		amount = new int[N+1]; // 구역이 1번부터이므로 N+1 크기의 배열 생성
		tokens = new StringTokenizer(input.readLine());
		all = new ArrayList[N+1];
		ans = Integer.MAX_VALUE;
		
		for(int i = 1; i <= N; i++) {
			amount[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i <= N; i++) {
			all[i] = new ArrayList<>();			
		}
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			
			for(int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(tokens.nextToken());
				all[i+1].add(tmp);
			}
		}
		
        // 선거구에 속한 지역은 최소 1개 ~ 최대 N-1개
		for(int i = 1; i < N; i++) {
			combi(i, 0, 1, new int[i]);
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
	
	// 팀 조합을 구해주는 메서드
	static void combi(int target, int cnt, int start, int[] a) {
		if(cnt == target) {
			// 같은 선거구의 구역들이 연결되었는지를 판단하는 메서드
			// 두 선거구 모두 연결된 구역들이라면 인구 차이를 구해주는 메서드 호출
			if(isConnect(a)) {
				calcAmount(a);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			a[cnt] = i;
			combi(target, cnt+1, i+1, a);
		}
	}

	static void calcAmount(int[] a) {
		int[] region = new int[N+1];
		
		// // 부분집합(a)에 속한 구역은 1, 속하지 않은 원소는 0으로 구분
		for(int i = 0; i < a.length; i++) {
			region[a[i]] = 1;
		}
		
		int region0 = 0;
		int region1 = 0;
		
		// 1선거구와 0선거구의 인구를 각각 구해주고
		for(int i = 1; i <= N; i++) {
			if(region[i] == 1) {
				region1 += amount[i];
			} else {
				region0 += amount[i];
			}
		}
		
		// 이전에 구한 인구수 차이와 비교해서 최소값을 계속 갱신
		ans = Math.min(ans, Math.abs(region0 - region1));
	}
	
	// 구역이 연결되었는가?
	static boolean isConnect(int[] a) {
		int[] region = new int[N+1];
		boolean flag = true; // 연결되지 않은 구역이 있는지를 저장할 변수
		
		// 부분집합(a)에 속한 구역은 1, 속하지 않은 원소는 0으로 구분
		for(int i = 0; i < a.length; i++) {
			region[a[i]] = 1;
		}
		
		// 1 선거구의 구역, 0 선거구의 구역 총 두 번 bfs 탐색으로 구역이 모두 연결되었는지를 확인
		for(int i = 1; i <= N; i++) {
			if(region[i] == 0) {
				if(!bfs(i, region, 0)) {
					flag = false;
					break;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(region[i] == 1) {
				if(!bfs(i, region, 1)) {
					flag = false;
					break;
				}
			}
		}
		
		// 각각의 선거구에 속한 지역끼리 연결되었다면 true, 아니면 false가 반환될 것
		return flag;
	}
	
	static boolean bfs(int start, int[] region, int team) {
		boolean[] visited = new boolean[N+1];
		Deque<Integer> que = new ArrayDeque<>();
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			visited[now] = true;
			
			for(int i = 0; i < all[now].size(); i++) {
				int next = all[now].get(i);
				// 이전에 방문하지 않았고, 같은 선거구에 속한 지역만 판독
				if(!visited[next] && region[next] == team) {
					visited[next] = true;
					que.offer(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			// 같은 선거구인데 방문하지 않았다면 연결된 게 아님 -> false 반환
			if(region[i] == team && !visited[i]) {
				return false;
			}
		}
		
		return true;
	}
}