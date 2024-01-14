import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] nums = new int[N];
		int[] ans = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int tmp = 0;
			for(int j = 0; j < N; j++) {
				if(ans[j] != 0) continue;				
				
				if(nums[i] == tmp) {
					ans[j] = i+1;
					break;
				}
				
				tmp++;
			}
		}
		
		for(int n: ans) {
			output.append(n).append(" ");
		}
		
		System.out.println(output);
	}
}