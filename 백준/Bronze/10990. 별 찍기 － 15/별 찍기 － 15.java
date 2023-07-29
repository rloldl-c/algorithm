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
		
		if(N == 1) {
			output.append("*");
		} else {			
			for(int i = 0; i < N; i++) {
				for(int j = 1; j < N - i; j++) {
					output.append(" ");
				}
				
				output.append("*");
			
				for(int j = 0; j < 2 * i - 1; j++) {
					output.append(" ");
				}
				
				if(i != 0) {
					output.append("*");
				}
				
				output.append("\n");
			}
		}
		
		System.out.println(output);
	}
}
