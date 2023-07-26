import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int a = Integer.parseInt(input.readLine());
		int b = Integer.parseInt(input.readLine());
		int c = Integer.parseInt(input.readLine());
		int num = a * b * c;
		int[] count = new int[10];
		
		while(num > 0) {
			int tmp = num % 10;
			num /= 10;
			count[tmp]++;
		}

		for(int n: count) {
			output.append(n).append("\n");
		}
		
		System.out.println(output);
	}
}
