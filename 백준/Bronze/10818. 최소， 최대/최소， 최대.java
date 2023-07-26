import java.io.*;
import java.util.*;;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			int now = Integer.parseInt(tokens.nextToken());
			min = Math.min(min, now);
			max = Math.max(max, now);
		}
		
		System.out.println(min + " " + max);
	}
}
