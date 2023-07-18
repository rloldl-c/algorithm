import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int boundary = 1;
		int num = 1;
		
		while(true) {
			if(boundary >= N) {
				break;
			}
			
			boundary += 6 * num;
			num++;
		}
		
		System.out.println(num);
	}

}
