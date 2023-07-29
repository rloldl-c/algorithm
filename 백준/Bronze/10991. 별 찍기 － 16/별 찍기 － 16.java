import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =  new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N - i - 1; j++) {
				output.append(" ");
			}
			
			for(int j = 0; j < 2 * i + 1; j++ ) {
				if(j % 2 == 0) {
					output.append("*");
				} else {
					output.append(" ");
				}
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
	}
}
