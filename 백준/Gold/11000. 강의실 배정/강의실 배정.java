import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		int N = Integer.parseInt(tokens.nextToken());
		int ans = 0;
		
		PriorityQueue<Lecture> lectures = new PriorityQueue<>();
		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			lectures.add(new Lecture(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken())));
		}
		
		while(!lectures.isEmpty()) {
			Lecture lec = lectures.poll();
			int start = lec.start;
			int end = lec.end;

			if(que.isEmpty()) {
				que.add(end);
			} else {
				if(que.peek() <= start) {
					que.poll();
				}
				
				que.add(end);
			}
			ans = Integer.max(ans, que.size());
		}
		
		System.out.println(ans);
	}
	
	static class Lecture implements Comparable<Lecture> {
		int start;
		int end;
		
		public Lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			return this.start - o.start;
		}
	}
}