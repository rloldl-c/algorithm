/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/2839
* @performance
* @category #그리디
* @note 
* 5를 최대한 많이 사용하는 게 봉투를 줄일 수 있음
* -> 3씩 줄이다가 5의 배수가 되면 5로 나눠버리기
*/

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int cnt = 0;

		while(N > -1) {
			if(N % 5 == 0) {
				break;
			}
			
			N -= 3;
			cnt++;
		}
		
		if(N < 0) {
			System.out.println(-1);
		} else {			
			System.out.println(cnt + N / 5);
		}
	}

}
