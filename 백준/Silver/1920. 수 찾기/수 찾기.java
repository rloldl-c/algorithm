/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/1920
* @performance
* @category #이분탐색
* @note 
*/
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int[] nums = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		Arrays.sort(nums);
		
		int M = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		
		for(int i = 0; i < M; i++) {
			int target = Integer.parseInt(tokens.nextToken());
			
			int start = 0;
			int end = N-1;
			int res = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(start < 0 || start >= N || end < 0 || end >= N) {
					break;
				}
								
				if(nums[mid] == target) {
					res = 1;
					break;
				}
				
				if(nums[mid] < target) {
					start = mid+1;
				} else {
					end = mid-1;
				}
			}
			
			output.append(res).append("\n");
		}
		
		System.out.println(output);
	}

}
