import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		permutation(0, new int[M], new boolean[N]);
		System.out.println(output);
	}
	
	public static void permutation(int cnt, int[] nums, boolean[] visited) {
		if(cnt == M) {
			for(int n: nums) {
				output.append(n).append(" ");
			}
			output.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				nums[cnt] = i+1;
				visited[i] = true;
				permutation(cnt + 1, nums, visited);
				visited[i] = false;
			}
		}
	}

}
