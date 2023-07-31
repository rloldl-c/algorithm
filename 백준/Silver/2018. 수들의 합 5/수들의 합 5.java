import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int ans = 0;
		
		for(int i = 1; i < N / 2 + 1; i++) {
			int now = i+1;
			int total = i;
			
			while(total < N) {
				total += now;
				now++;
			}
			
			if(total == N) {
				ans++;
			}
		}
		
		System.out.println(ans+1);
	}

}
