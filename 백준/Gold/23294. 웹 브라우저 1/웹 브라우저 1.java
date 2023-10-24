import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static Deque<Integer> front, back;
	static int N, Q, C, cache, now;
	static int[] pages;

	public static void main(String[] args) throws IOException {
    	tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		Q = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		pages = new int[N+1];
		tokens = new StringTokenizer(input.readLine(), " ");
		
		for(int i = 1; i <= N; i++) {
			pages[i] = Integer.parseInt(tokens.nextToken());
		}
		
		front = new ArrayDeque<>();
		back = new ArrayDeque<>();
		
		for(int i = 0; i < Q; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			char cmd = tokens.nextToken().charAt(0);
			
			if(cmd == 'B') {
				goBack();
			} else if(cmd == 'F') {
				goFront();
			} else if(cmd == 'A') {
				int n = Integer.parseInt(tokens.nextToken());			
				connectPage(n);
			} else {
				compress();
			}
		}
		
		output.append(now).append("\n");
		
		if(back.size() == 0) {
			output.append(-1).append("\n");
		} else {
			while(!back.isEmpty()) {
				output.append(back.poll()).append(" ");
			}
			output.deleteCharAt(output.length()-1);
			output.append("\n");
		}
		
		
		if(front.size() == 0) {
			output.append(-1);
		} else {
			while(!front.isEmpty()) {
				output.append(front.poll()).append(" ");
			}
			output.deleteCharAt(output.length()-1);
		}
		
		System.out.println(output);
	}
	
	public static void goFront() {
		if(front.isEmpty()) {
			return;
		}
		
		back.offerFirst(now);
		now = front.poll();
	}

	public static void goBack() {
		if(back.isEmpty()) {
			return;
		}
		
		front.offerFirst(now);
		now = back.poll();
	}
	
	public static void connectPage(int n) {
		// 캐시 줄이기
		while(!front.isEmpty()) {
			int tmp = front.poll();
			cache -= pages[tmp];
		}
		
		if(now != 0) {
			back.offerFirst(now);
		}

		now = n;
		cache += pages[n];
		
		while (!back.isEmpty()) {			
			if(cache <= C) {
				break;
			}
			
			int tmp = back.pollLast();
			cache -= pages[tmp];
		}
	}
	
	public static void compress() {
		if(back.isEmpty()) {
			return;
		}
		
		Deque<Integer> tmp = new ArrayDeque<>();
		int now = back.poll();
		tmp.offerLast(now);
		
		while(!back.isEmpty()) {
			int next = back.poll();
			
			if(now == next) {
				cache -= pages[next];
				continue;
			} else {
				tmp.offerLast(next);
				now = next;
			}
		}
		
		while(!tmp.isEmpty()) {
			back.offerFirst(tmp.pollLast());
		}
		
	}
}
