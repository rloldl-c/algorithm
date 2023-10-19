import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws IOException {
		PriorityQueue<Info> que = new PriorityQueue<>();
		
		int N = Integer.parseInt(input.readLine());
		int[] ans = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(tokens.nextToken());
			int start = Integer.parseInt(tokens.nextToken());
			int end = Integer.parseInt(tokens.nextToken());
			
			que.offer(new Info(n, start, end));
		}
		
		int cnt = 0;
		ArrayList<Integer> room = new ArrayList<>();

		Info now = que.poll();
		room.add(now.end);
		
		ans[now.no] = 1;
		
		while(!que.isEmpty()) {
			now = que.poll();
			boolean empty = false;
					
			for(int i = 0; i < room.size(); i++) {
				// 강의실 사용 종료 시간이 이번 강의 시작 시간보다 작으면 강의실 사용 가능
				if(room.get(i) <= now.start) {
					room.set(i, now.end);
					empty = true;
					ans[now.no] = i+1;
					break;
				}
			}
			
			if(!empty) {
				room.add(now.end);
				ans[now.no] = room.size();
			}
		}
		
		System.out.println(room.size());
		
		for(int i = 1; i < ans.length; i++) {
			output.append(ans[i]).append('\n');
		}
		
		System.out.println(output);
	}
	
	static class Info implements Comparable<Info> {
		int no, start, end;

		public Info(int no, int start, int end) {
			super();
			this.no = no;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Info o) {
			return this.start - o.start;
		}
	}
}