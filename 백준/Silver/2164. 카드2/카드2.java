/**
 * @author 은비
 * @since 2023-08-04
 * @see https://www.acmicpc.net/problem/2164
 * @performance
 * @category #큐
 * @note
 * 1번부터 N까지 큐에 넣기
 * poll -> poll한 수를 offer
 * 위 과정을 큐 사이즈가 1이 될 때까지 반복
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	static ArrayDeque<Integer> cards;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		cards = new ArrayDeque<>();
		
		for(int n = 1; n <= N; n++) {
			cards.offer(n);
		}
		
		while(cards.size() > 1) {
			cards.poll();
			
			int tmp = cards.poll();
			cards.offer(tmp);
		}
		
		System.out.println(cards.poll());
	}

}
