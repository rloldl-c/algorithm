import java.util.Scanner;

public class Main { 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt(); //고정비용(노트북 개수와 상관 x)
		int b = in.nextInt(); //가변비용(노트북 개수와 비례)
		int c = in.nextInt(); //판매가격
		int n = 0; //노트북 개수
		
		if(b == c | b > c) {
			System.out.println(-1);
		}
		else {
			n = (int)a / (c - b);
			System.out.println(n + 1);
		}
		
	}
}