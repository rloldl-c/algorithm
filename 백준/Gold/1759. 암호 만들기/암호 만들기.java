/**
* @author 은비
* @since 2023-08-22
* @see https://www.acmicpc.net/problem/1759
* @performance
* @category
* @note 
* 주어진 알파벳 정렬 후 순열
* 순열로 뽑힌 알파벳 중에 자음과 모음 개수 세어서 조건에 부합하는지 확인하고
* 부합하지 않으면 다음 순열로 넘어가서 확인
*/

import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int L, C;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		L = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		arr = new char[C];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = tokens.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		permu(0, 0, new char[L]);
		System.out.println(output);
	}

	private static void permu(int cnt, int start, char[] tmp) {
		if(cnt == L) {
			isValid(tmp);
			return;
		}
		
		for(int i = start; i < C; i++) {
			tmp[cnt] = arr[i];
			permu(cnt+1, i+1, tmp);
		}
	}
	
	private static void isValid(char[] tmp) {
		int cnt1 = 0; // 모음
		int cnt2 = 0; // 자음
		
		for(int i = 0; i < tmp.length; i++) {
			if("aeiou".indexOf(tmp[i]) > -1) {
				cnt1++;
			} else {
				cnt2++;
			}
			
			if(cnt1 >= 1 && cnt2 >= 2) {
				for(int j = 0; j < L; j++) {
					output.append(tmp[j]);
				}
				output.append("\n");
				return;
			}
		}
	}
}