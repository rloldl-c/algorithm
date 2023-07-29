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
		for(int i = N; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				output.append("*");
			}
			output.append("\n");
		}
		System.out.println(output);
	}
}
