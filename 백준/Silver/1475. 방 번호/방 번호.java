import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		String num = input.readLine();
		int[] set = new int[10];
		int ans = 0;
		
		for(int i = 0; i < num.length(); i++) {
			int now = num.charAt(i) - '0';

			if(now == 6 || now == 9) {
				if(set[6] > set[9]) {
					set[9]++;
					continue;
				} else if(set[6] < set[9]) {
					set[6]++;
					continue;
				}
			}
			
			set[now]++;
		}
		
		Arrays.sort(set);
		System.out.println(set[9]);
	}

}
