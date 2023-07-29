/** 1: * 1개  " " 8개 * 1개
 * 2: * 2개 " " 6개 * 2개
 * 3: * 3개 " " 4개 * 3개
 * 4: * 4개 " " 2개 * 4개
 * 5: * 5개 " " 0개 * 5개
 */

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
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				output.append("*");
			}
			
			for(int j = 1; j <= 2 * (N - i); j++) {
				output.append(" ");
			}
			
			for(int j = 1; j <= i; j++) {
				output.append("*");
			}
			output.append("\n");
		}
		
		for(int i = N-1; i > 0; i--) {
			for(int j = 1; j <= i; j++) {
				output.append("*");
			}
			
			for(int j = 1; j <= 2 * (N - i); j++) {
				output.append(" ");
			}
			
			for(int j = 1; j <= i; j++) {
				output.append("*");
			}
			output.append("\n");
		}	
		System.out.println(output);
	}
}
