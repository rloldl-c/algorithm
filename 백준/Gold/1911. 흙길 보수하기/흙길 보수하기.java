import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int L = Integer.parseInt(tokens.nextToken());
		ArrayList<Info> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			list.add(new Info(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
		}
		
		Collections.sort(list);

		int cnt = 0;
		int prev = 0;
		for(int i = 0; i < N; i++) {
			Info now = list.get(i);
			
			if(now.start > prev) {
				prev = now.start;
			}
			
			while(prev < now.end) {
				prev += L;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	static class Info implements Comparable<Info> {
		int start;
		int end;
		
		public Info(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Info o) {
			return this.start - o.start;
		}
	}
}