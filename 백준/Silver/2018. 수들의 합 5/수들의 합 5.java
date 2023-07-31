import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int r = 1, l = 1;
		int total = 0;
		int ans = 0;
		
		while(r < N) {
			if(total <= N) {
				total += r;
				r++;
			} else if(total > N) {
				total -= l;
				l++;
			}
			
			if(total == N) {
				ans++;
			}
		}
		
		System.out.println(ans+1);
	}

}