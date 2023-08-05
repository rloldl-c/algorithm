/**
 * @author 은비
 * @since 20223-08-05
 * @see https://www.acmicpc.net/problem/2023
 * @performance
 * @category #재귀 #소수
 * @note
 * 에라토스테네스의 체는 최대 10^8개의 boolean 배열이 필요하므로 4MB로는 사용 불가
 * 첫 번째 자리 수부터 소수가 아닌 수가 나오면 그 수로 시작하는 모든 수들은 신기한 소수가 될 수 없음
 * 소수인 수에 다음 수를 붙여 가면서 소수인지 판별하는 재귀함수 만들기
 * 1은 소수가 아니므로 다음 수를 붙여서 소수인지 확인할 필요 X
 * 22는 소수가 아니므로 다음 수를 붙여서 소수인지 확인할 필요 X
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N, ans;
	static int[] notPrime;
	static boolean isAmazingPrime;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		nextNum(0, N);
		
		System.out.println(output);
	}
	
	static void nextNum(int now, int nth) {
		if(nth == 0) {
			if(isPrime(now)) {
				output.append(now).append("\n");
			}
			
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			int next = now * 10 + i;
			
			if(isPrime(next)) {
				nextNum(next, nth-1);
			}
		}
	}
	
	static boolean isPrime(int n) {
		if(n < 2) {
			return false;
		}

		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
