import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int K = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		int[] arr = new int[K];
		long s = 1;
		long e = 0;
		long res = 0;
		
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(input.readLine());
			
			if(e < arr[i]) e = arr[i];
		}
		
		while(s <= e) {
			long mid = (s + e) / 2;
			long cnt = 0;
			
			for(int n: arr) {
				cnt += n / mid;
			}
			
			if(cnt >= N) {
				res = mid;
				s = mid+1;
			} else {
				e = mid-1;
			}
		}
		
		System.out.println(res);
	}

}