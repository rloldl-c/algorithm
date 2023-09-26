/**
 * @author 은비
 * @since 2023-09-26
 * @see https://www.acmicpc.net/problem/2110
 * @performance 
 * @category #이분탐색
 * @note
 * 두 공유기 사이 최소 거리 : 1
 * 두 공유기 사이 최대 거리 : 입력으로 들어온 집 좌표를 정렬 했을 때 맨 앞 집 좌표와 맨 뒷 집 좌표 차이
 * 							  (예제에선 9 - 1: 8)
 * 최소 거리와 최대 거리 사이에서 적당한 값을 찾아야 함
 * -> 이분탐색으로 시간 줄이기
 * mid값을 공유기를 설치해야할 최소 거리로 잡고
 * 현재 공유기가 설치된 집 좌표(prev)에서 그 다음 집(home[i])의 거리가 mid보다 클 때만 설치
 * 공유기를 하나 설치할 때마다 공유기 개수(cnt)를 하나 올려가면서 모든 집을 탐색
 * 탐색이 끝나면 입력으로 주어진 공유기 개수(C)와 비교해서 mid값을 조정해줘야 함
 * 입력으로 주어진 공유기 개수보다 현재 설치한 공유기 개수가 적다면 최소 거리가 너무 먼 것
 * = mid 값을 줄여줘야 하므로 e를 옮기기
 * 그렇지 않다면 정답 후보가 될 수 있으므로 현재 저장된 정답(ans)과 비교해서 더 큰 값을 저장
 * 
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int C = Integer.parseInt(tokens.nextToken());
		int[] home = new int[N];
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(input.readLine());
		}
		
		Arrays.sort(home);
		
		int s = 1;
		int e = home[N-1] - home[0];
		
		while(s <= e) {
			// 공유기 사이 최소 거리
			int mid = (s+e) / 2;
			int prev = home[0];
			int cnt = 1; // 0번째에 하나 설치한 것이므로 이미 1개부터 시작
			for(int i = 1; i < N; i++) {
				if(home[i] - prev >= mid) {
					cnt++;
					prev = home[i];
				}
			}
			
			// C개 설치 불가능 -> 설치 간격 좁혀주기
			if(cnt < C) {
				e = mid-1;
			} else {
				ans = Math.max(ans, mid);
				s = mid+1;
			}
		}
		
		System.out.println(ans);
	}
}