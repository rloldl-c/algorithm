import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int[] sides = new int[3];
		
		for(int i = 0; i < 3; i++) {
			sides[i] = sc.nextInt();
		}
		
		while (true) {
			if(sides[0] == sides[1] && sides[1] == sides[2] && sides[0] == 0) {
				break;
			}
			
			int max = 0;
			
			for(int side: sides) {
				if(max < side) {
					max = side;
				}
			}
			
			double sum = 0;
			
			for(int side: sides) {
				if(side != max) {
					sum += Math.pow(side, 2);
				}
			}
			
			if(sum == Math.pow(max, 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
			
			for(int i = 0; i < 3; i++) {
				sides[i] = sc.nextInt();
			}
		}

	}

}
