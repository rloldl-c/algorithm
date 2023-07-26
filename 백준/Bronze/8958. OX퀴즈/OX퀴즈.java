import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());
		for(int t = 0; t < T; t++) {
			int ans = 0;
			int cnt = 0;
			String quiz = input.readLine();
			
			for(int i = 0; i < quiz.length(); i++) {
				if(quiz.charAt(i) == 'O') {
					ans += ++cnt;
					if(i + 1 < quiz.length() && quiz.charAt(i+1) != 'O') {
						cnt = 0;
					}
				}
			}
			
			output.append(ans).append("\n");
		}
		
		System.out.println(output);
	}

}
