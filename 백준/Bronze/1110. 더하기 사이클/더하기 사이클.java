import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(input.readLine());
		int now = num;
		int next = 0;
		int cnt = 1;
		
		if (num < 10) {
			next = num * 11;
		} else {
			next = (num % 10) * 10 + (((num % 10) + (num / 10)) % 10);
		}
		
		now = next;
		
		while(now != num) {
			if(now < 10) {
				next = now * 11;
			} else {
				next = (now % 10) * 10 + (((now % 10) + (now / 10)) % 10);
			}
			
			cnt++;
			now = next;
		}
		
		System.out.println(cnt);
	}
}
