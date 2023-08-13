import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int res = 0;
		int cnt = 0;
		int num = 666;
		
		while(true) {
			cnt = 0;
			String tmp = String.valueOf(num);
			
			if(tmp.contains("666")) {
				++res;
			}
			
			if(res == N) {
				break;
			}
			
			num++;
		}
		
		System.out.println(num);
	}

}