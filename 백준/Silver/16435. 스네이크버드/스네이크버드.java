/**
* @author 은비
* @since 2023-008-11
* @see https://www.acmicpc.net/problem/16435
* @performance
* @category #정렬
* @note 
* 입력받은 과일 높이들을 오름차순으로 정렬
* 뱀 길이에 1씩 더해가면서 현재 과일 높이보다 높은지 낮은지를 판단
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int L = Integer.parseInt(tokens.nextToken());
		int[] h = new int[N];
		int cnt = 0;
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(h);
		
		for(int i = 0; i < N; i++) {
			if(L < h[i]) {
				break;
			}
			
			L++;
		}
		
		System.out.println(L);
	}

}
