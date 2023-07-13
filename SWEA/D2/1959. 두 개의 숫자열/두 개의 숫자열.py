import java.util.*;

class Solution
{
	public static int findMax(int [] longArray, int [] shortArray) {
		int ans = 0;
		
		for(int i = 0; i < longArray.length - shortArray.length + 1; i++) {
			int sum = 0;
			for(int j = 0; j < shortArray.length; j++) {
				sum += longArray[i+j] * shortArray[j];
			}
			
			ans = Math.max(ans, sum);
		}
		
		return ans;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int [] A = new int [N];
			int [] B = new int [M];
			int ans = 0;
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			if(N < M) {
				ans = findMax(B, A);
			} else {
				ans = findMax(A, B);
			}
			
			System.out.println("#" + test_case + " " + ans);
			
		}
	}
}