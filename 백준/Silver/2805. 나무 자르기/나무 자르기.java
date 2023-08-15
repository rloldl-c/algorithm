/**
* @author 은비
* @since 2023-08-15
* @see https://www.acmicpc.net/problem/2805
* @performance
* @category #이분탐색
* @note 
* 나무들의 높이들 중 가장 낮은 높이와 가장 높은 높이 사이의 값으로 H를 설정해줘야 함
*/
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[] trees = new int[N];
		int res = 0;
		int s = 1;
		int e = 0;
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(tokens.nextToken());
			if(e < trees[i]) e = trees[i];
		}
				
		while (s < e) {
			int mid = (s+e) / 2;
			long tmp = 0;
			
			for(int i = 0; i < N; i++) {
				if(trees[i] > mid) {
					tmp += trees[i] - mid;
				}
			}
									
			if(tmp >= M) {
				s = mid+1;
				res = Math.max(mid, res);
			} else {
				e = mid;
			}
		}
		
		System.out.println(res);
	}

}