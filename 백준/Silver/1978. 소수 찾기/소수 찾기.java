import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			int num = in.nextInt();
			boolean p = isPrimeNum(num);
			if(p == true) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	public static boolean isPrimeNum(int num) {
		if(num == 1) {
			return false;
		}
		
		for(int i = 2; i <num; i++) {
			if(num % i == 0) {
				return false;
			}
			
		}
		
		return true;
	}

}