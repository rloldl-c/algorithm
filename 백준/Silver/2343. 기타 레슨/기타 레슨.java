/**
* @author 은비
* @since 2023-08-13
* @see https://www.acmicpc.net/problem/2343
* @performance
* @category #이분탐색
* @note 
* 블루레이의 최대 크기 : 모든 강의 길이의 합
* 블루레이의 최소 크기 : 가장 긴 강이의 길이
* 최소 크기부터 최대 크기까지 이분 탐색으로 길이를 정하고
* 그 길이로 녹화할 경우 몇 개의 블루레이가 나오는지 계산
* 계산한 블루레이 개수보다 M이 더 크면 현재 녹화 길이보다 줄여서 다시 탐색
* 반대로 계산한 블루레이 개수보다 M이 더 작으면 현재 녹화 길이보다 늘려서 다시 탐색
* 위 과정을 M과 일치할 때까지 반복 
* -> 최소값을 찾아야 하므로 M과 일치하더라도 더 작은 값이 있는지 확인해야함
* cnt == M을 탈출 조건으로 하면 안됨
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] video;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int ans = 0;
		
		video = new int[N];
		int e = 0;
		int s = 0;
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			video[i] = Integer.parseInt(tokens.nextToken());
			
			e += video[i];
			
			if(s < video[i]) {
				s = video[i];
			}
		}

		while(s <= e) {
			int cnt = 1;
			int mid = (s+e) / 2;
			int now = 0;

			for(int i = 0; i < N; i++) {
				if(now + video[i] > mid) {
					cnt++;
					now = 0;
				}
				
				if(cnt > M) {
					break;
				}
				
				now += video[i];
			}

			if(cnt <= M) {
				e = mid-1;
				ans = e;
			} else {
				s = mid+1;
			}
		}
		
		System.out.println(ans+1);
	}

}