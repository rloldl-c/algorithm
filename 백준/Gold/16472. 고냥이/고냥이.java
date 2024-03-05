import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		String str = input.readLine();
		int[] visited = new int[26];
		int ans = 0;
		int cnt = 0;
		
		int start = 0;
		int end = 1;

		if(str.charAt(start) == str.charAt(end)) {
			cnt = 1;
			visited[str.charAt(start) - 'a'] = 2;
		} else {
			cnt = 2;
			visited[str.charAt(start) - 'a'] = 1;
			visited[str.charAt(end) - 'a'] = 1;
		}
		
		while(end < str.length()) {			
			if(cnt > N) {
				visited[str.charAt(start) - 'a'] -= 1;
				
				if(visited[str.charAt(start) - 'a'] == 0) {
					cnt--;
				}
				
				start++;
			} 
			
			if(cnt <= N || start >= end){
				ans = Math.max(ans, end-start+1);
				
				if(end+1 < str.length()) {
					if(visited[str.charAt(end+1) - 'a'] == 0) {
						cnt++;
					}
					
					visited[str.charAt(end+1) - 'a'] += 1;
					
				}
				
				end++;
			}
		}
		
		System.out.println(ans);
		
	}
}