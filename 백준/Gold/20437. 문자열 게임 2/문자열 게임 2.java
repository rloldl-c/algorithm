import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int T = Integer.parseInt(tokens.nextToken());

		for(int t = 0; t < T; t++) {
			int[] alphabet = new int[26];
			char[] arr = input.readLine().toCharArray();
			
			for(char c: arr) {
				alphabet[c - 'a']++;
			}
			
			int K = Integer.parseInt(input.readLine());
			int minLen = arr.length + 1;
			int maxLen = -1;
			
			for(int i = 0; i < arr.length; i++) {
				int idx = arr[i] - 'a';
				int cnt = 0;
				
				if(alphabet[idx] < K) {
					continue;
				}
				
				for(int j = i; j < arr.length; j++) {
					if(arr[i] == arr[j]) {
						cnt++;

						if(cnt == K) {
							minLen = Integer.min(minLen, j - i + 1);
							maxLen = Integer.max(maxLen, j - i + 1);
							break;
						}
					}
					
				}
			}
			
			if(maxLen == -1 || minLen == arr.length + 1) {
				output.append(-1);
			} else {
				output.append(minLen).append(" ").append(maxLen);
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
	}

}