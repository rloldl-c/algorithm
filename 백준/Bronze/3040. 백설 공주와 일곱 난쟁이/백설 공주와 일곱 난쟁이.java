/**
* @author 은비
* @since 2023-08-11
* @see https://www.acmicpc.net/problem/3040
* @performance
* @category #완전탐색
* @note 
* 9개의 수 중 2개를 빼서 합이 100이 되게 만들기
* 주어진 수를 모두 더한 총합 구하고 2중 for문으로 2개의 조합 만들기
* 총합에서 만들어진 수 두개를 뺐을 때 100이 되면 해당 인덱스 수를 0으로 만들고 반복문 빠져나오기
* 마지막엔 원본 배열을 탐색하면서 0이 아닌 수들만 출력
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int sum = 0;
		int[] arr = new int[9];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(input.readLine());
			sum += arr[i];
		}

		for(int i = 0; i < 8; i++) {
			int tmp = 0;
			
			for(int j = i+1; j < 9; j++) {
				tmp = sum - arr[i] - arr[j];
				
				if(tmp == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break;
				}
			}
			
			if(tmp == 100) break;
		}
		
		for(int n: arr) {
			if(n != 0) {
				output.append(n).append("\n");
			}
		}
		
		System.out.println(output);
	}

}
