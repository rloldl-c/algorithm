/* 이분탐색
 * 벌레와 장애물의 높이가 같을 땐 파괴 가능
 * 파괴해야 하는 장애물 수 = 벌레의 높이와 같거나 큰 장애물의 수
 * 1부터 H까지 이분탐색으로 벌레의 높이와 같거나 큰 첫 수의 찾기..?
 * 석순 / 종유석 다른 배열로 관리
 */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int H = Integer.parseInt(tokens.nextToken());
		int min = N;
		int ans = 0;
		
		int[] top = new int[N/2];
		int[] bottom = new int[N/2];
		for(int i = 0; i < N/2; i++) {
			bottom[i] = Integer.parseInt(input.readLine());
			top[i] = Integer.parseInt(input.readLine());
		}
		
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		for(int i = 1; i <= H; i++) {
			int cnt = binarySearch(0, i, bottom) + binarySearch(0, H - i + 1, top);
			
			if(cnt == min) {
				ans++;
			}
			
			if(cnt < min) {
				min = cnt;
				ans = 1;
			}
		}
		
		System.out.println(min + " " + ans);
	}
	
	static int binarySearch(int start, int h, int[] arr) {
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= h) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return arr.length - start;
	}
}