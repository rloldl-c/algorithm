import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		int[] dist = new int[N-1];
		int[] price = new int[N-1];
		
		StringTokenizer tokens1 = new StringTokenizer(input.readLine());
		StringTokenizer tokens2 = new StringTokenizer(input.readLine());
		for(int i = 0; i < N-1; i++) {
			dist[i] = Integer.parseInt(tokens1.nextToken());
			price[i] = Integer.parseInt(tokens2.nextToken());
		}
		
		int min = price[0];
		int ans = price[0] * dist[0];
		
		for(int i = 1; i < N-1; i++) {
			if(min > price[i]) {
				min = price[i];
			}
			
			ans += min * dist[i];
		}
		
		System.out.println(ans);
	}

	static String src = "4\r\n" + 
			"3 3 4\r\n" + 
			"1 1 1 1";
}