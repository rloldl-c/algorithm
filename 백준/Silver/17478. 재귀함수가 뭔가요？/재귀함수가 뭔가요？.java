import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 은비
 * @since 2023-08-01
 * @see https://www.acmicpc.net/problem/17478
 * @performance
 * @category #재귀
 * @note 재귀가 깊어질수록 언더바 개수가 늘어남
 * 언더바 4개가 반복되는 횟수를 매개변수로 전달
 */

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		output.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		
		answer(0);
		
		System.out.println(output);
	}
	
	public static void answer(int n) {
		StringBuilder line = new StringBuilder();
		
		for(int i = 0; i < n; i++) {
			line.append("____");
		}
		
		output.append(line).append("\"재귀함수가 뭔가요?\"\n");
		

		if(n == N) {
			output.append(line).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			output.append(line).append("라고 답변하였지.").append("\n");
			return;
		} 
		
		output.append(line).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		output.append(line).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		output.append(line).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		answer(n+1);

		output.append(line).append("라고 답변하였지.").append("\n");
	}

}
