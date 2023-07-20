import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> nums = new Stack<>();
		
		for(int i = 0; i < K; i++) {
			int n = sc.nextInt();
			
			if(n == 0) {
				nums.pop();
			} else {
				nums.add(n);
			}
		}
		
		int sum = 0;
		for(int n: nums) {
			sum += n;
		}
		
		System.out.println(sum);
	}
}
