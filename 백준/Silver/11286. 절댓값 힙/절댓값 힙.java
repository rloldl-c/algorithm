import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);
				
				if(abs1 == abs2) {
					return o1 - o2;
				}
				
				return abs1 - abs2;
			}
		});
		
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(input.readLine());
			
			if(x == 0) {
				if(que.isEmpty()) {
					output.append(0).append("\n");
				} else {
					output.append(que.poll()).append("\n");
					continue;
				}
				
			} else {
				que.offer(x);				
			}
		}

		System.out.println(output);
	}

}