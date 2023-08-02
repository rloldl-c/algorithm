/**
 * @author 은비
 * @since 2023-08-02
 * @see https://www.acmicpc.net/problem/11659
 * @performance
 * @category #
 * @note
 * 입력으로 들어온 수 대신 해당 인덱스까지 모두 더한 수로 배열에 저장
 * 5 4 3 2 1 -> 5 9 12 14 15
 * 구해야 하는 구간 끝 인덱스 수에서 시작 인덱스 수를 뺀 값을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int[] nums = new int[N+1];
		
		tokens = new StringTokenizer(input.readLine());
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += Integer.parseInt(tokens.nextToken());
			nums[i] = sum;
		}
		
		for(int i = 0; i < M; i++) {
			tokens = new StringTokenizer(input.readLine());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			
			output.append(nums[end] - nums[start-1]).append("\n");
		}
		
		System.out.println(output);
	}

}
