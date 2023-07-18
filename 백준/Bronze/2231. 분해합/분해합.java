import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int ans = 0;
		int add = 0;
		
		for(int i = 1; i < N; i++) {
			ans = i;
			add = i;
			int num = i;
			
			while (num > 0) {
				add += num % 10;
				num = (int)(num / 10);
			}
			
			if(add == N) {
				break;
			}
		}
		
		if(add == N) {
			System.out.println(ans);
		} else {
			System.out.println(0);
		}
	}
}
