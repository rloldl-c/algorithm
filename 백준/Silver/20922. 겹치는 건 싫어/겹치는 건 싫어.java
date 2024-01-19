import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int K = Integer.parseInt(tokens.nextToken());
		int ans = 0;
		
		int[] nums = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(tokens.nextToken());
		}
		
		int[] cnt = new int[100001];
		int start = 0;
		int end = 1;
		cnt[nums[start]] += 1;
		cnt[nums[end]] += 1;
		
		while(true) {
			ans = Integer.max(ans, end - start + 1);
			
			if((end+1) >= N) break;

			int next = end + 1;
			
			if(cnt[nums[next]] < K) {
				cnt[nums[next]] += 1;
				end = next;
			} else {
				cnt[nums[start]] -= 1;
				start += 1;
			}
		}
		
		System.out.println(ans);
	}
}