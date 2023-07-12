import java.util.*;

class Solution
{
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int [][] sudoku = new int [9][9];
			int res = 1;
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < 9; i++) {
				int [] check = new int [9];
				for(int j = 0; j < 9; j++) {
					int now = sudoku[i][j];
					check[now-1] += 1;
				}
				
				for(int j = 0; j < 9; j++) {
					if(check[j] == 0) {
						res = 0;
						break;
					}
				}
				
				if(res == 0) {
					break;
				}
			}
			
			if(res == 1) {
				for(int i = 0; i < 9; i++) {
					int [] check = new int [9];
					for(int j = 0; j < 9; j++) {
						int now = sudoku[j][i];
//						System.out.println(j);
						check[now-1] += 1;
					}
					
					for(int j = 0; j < 9; j++) {
						if (check[j] == 0) {
							res = 0;
							break;
						}
					}
					
					if (res == 0) {
						break;
					}
				}
				
			}
			
			if(res == 1) {
				for(int i = 0; i < 7; i+=3) {
					for(int j = 0; j < 7; j+=3) {
						int [] check = new int [9];
						for(int m = 0; m < 3; m++) {
							for(int n = 0; n < 3; n++) {
								int now = sudoku[i+m][j+n];
								check[now-1] += 1;
							}
						}
						for(int k = 0; k < 9; k++) {
							if(check[k] == 0) {
								res = 0;
								break;
							}
						}
					}
					
				}
			}
			
			System.out.println("#" + test_case + " " + res);
			
		}
	}
}