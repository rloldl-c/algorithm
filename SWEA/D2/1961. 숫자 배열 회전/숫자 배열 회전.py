import java.util.*;

class Solution
{	
	public static int[][] rotation(int [][] arr) {
		int[][] newArr = new int [arr.length][arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				newArr[i][j] = arr[arr.length-j-1][i];
			}
		}

		return newArr;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[][] arr = new int [N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int[][] arr90 = rotation(arr);
			int[][] arr180 = rotation(arr90);
			int[][] arr270 = rotation(arr180);
			
			System.out.println("#" + test_case);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr90[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr180[i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr270[i][j]);
				}
				System.out.println();
			}
		}
	}
}