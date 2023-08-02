import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, nums[];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		nums = new int[M];
		
		sequence(0, 0);
		System.out.println(output);
	}
	
	public static void sequence(int cnt, int start) {
		if(cnt == M) {
			for(int n: nums) {
				output.append(n).append(" ");
			}
			
			output.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			nums[cnt] = i+1;
			sequence(cnt + 1, i+1);
		}
	}

}
