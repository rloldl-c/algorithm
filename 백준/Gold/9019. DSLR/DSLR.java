import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] oper;
	static String[] visited;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(input.readLine());

		for(int t = 0; t < T; t++) {
			tokens = new StringTokenizer(input.readLine());
			int before = Integer.parseInt(tokens.nextToken());
			int after = Integer.parseInt(tokens.nextToken());
			String[] cmd = new String[10000];
			visited = new String[10000];

			oper(before);

			output.append(visited[after] + "\n");
		}
		
		System.out.println(output);
	}
	
	static void oper(int num) {
		Deque<Pair> que = new ArrayDeque<>();
		que.offer(new Pair(num, ""));
		visited[num]= "";
		
		while(!que.isEmpty()) {
			Pair now = que.poll();
			int n = now.n;
			String str = now.s;
			
			int d = D(n);
			int s = S(n);
			int l = L(n);
			int r = R(n);
			
			if(visited[d] == null) {
				visited[d] = str + "D";
				que.offer(new Pair(d, str+"D"));
			}
			
			if(visited[s] == null) {
				visited[s] = str + "S";
				que.offer(new Pair(s, str+"S"));
			}
			
			if(visited[l] == null) {
				visited[l] = str + "L";
				que.offer(new Pair(l, str + "L"));
			}
			
			if(visited[r] == null) {
				visited[r] = str + "R";
				que.offer(new Pair(r, str + "R"));
			}
		}
	}
	
	static int D(int n) {
		if(2*n > 9999) {
			return 2 * n % 10000;
		}
		
		return 2 * n;
	}
	
	static int S(int n) {
		if(n == 0) {
			return 9999;
		}
		
		return n - 1;
	}
	
	static int L(int n) {
		if(n > 999) {
			return (n % 1000) * 10 + (n / 1000);
		}
		
		return n * 10;
	}
	
	static int R(int n) {
		if(n < 10) {
			return n * 1000;
		}
		
		return (n % 10) * 1000 + (n / 10);
	}
	
	static class Pair {
		int n;
		String s;
		
		public Pair(int n, String s) {
			super();
			this.n = n;
			this.s = s;
		}
	}
}