/**
 * @author 은비
 * @since
 * @see https://www.acmicpc.net/problem/12891
 * @performance
 * @category #문자열, #맵
 * @note
 * start = 0, end = P로 설정하고 1씩 더해가면서 등장하는 횟수 수정
 * A, C, G, T를 키로, 등장하는 횟수를 value로 갖는 맵 생성
 * 첫 번째 탐색에서는 0번째부터 P까지 A, C, G, T가 몇 번 등장하는지 count해서 맵에 값 넣기
 * 다음 탐색부터는 start에 해당하는 알파벳의 횟수를 1 빼고  end+1에 해당하는 알파벳 횟수에 1 더해주기
 * 최소 등장 횟수를 만족하는지 검사하고 만족하면 ans+1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Map<Character, Integer> count, minimum;

	public static void main(String[] args) throws IOException {
		count = new HashMap<Character, Integer>() {{
				put('A', 0);
				put('C', 0);
				put('G', 0);
				put('T', 0);				
		}};
		
		int ans = 0;
		
		tokens = new StringTokenizer(input.readLine());
		int S = Integer.parseInt(tokens.nextToken());
		int P = Integer.parseInt(tokens.nextToken());
		
		String dna = input.readLine();
		
		tokens = new StringTokenizer(input.readLine());
		
		minimum = new HashMap<Character, Integer>() {{
			put('A', Integer.parseInt(tokens.nextToken()));
			put('C', Integer.parseInt(tokens.nextToken()));
			put('G', Integer.parseInt(tokens.nextToken()));
			put('T', Integer.parseInt(tokens.nextToken()));				
		}};

		int start = 0;
		int end = P-1;
		
		for(int i = start; i <= end; i++) {
			count.put(dna.charAt(i), count.get(dna.charAt(i))+1);
		}
		
		if(checkChar()) {
			ans++; 
		}

		for(int i = 0; i < S - P; i++) {
			count.put(dna.charAt(start), count.get(dna.charAt(start))-1);
			count.put(dna.charAt(end+1), count.get(dna.charAt(end+1))+1);
			
			if(checkChar()) {
				ans++; 
			}

			start++;
			end++;

		}
		
		System.out.println(ans);
			
	}
	
	static boolean checkChar() {
		if(minimum.get('A') > count.get('A')) {
			return false;
		}
		if(minimum.get('C') > count.get('C')) {
			return false;
		}
		if(minimum.get('G') > count.get('G')) {
			return false;
		}
		if(minimum.get('T') > count.get('T')) {
			return false;
		}
		
		return true;
	}
	
}
