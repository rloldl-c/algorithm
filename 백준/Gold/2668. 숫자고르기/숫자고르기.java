/* 예제에서
 * 1 -> 3
 * 3 -> 1(처음 시작인 1로 끝남)
 * 이런 식으로 다시 처음으로 돌아오는 지점 찾기
 * 둘째 줄의 수를 첫째 줄의 인덱스로 삼고 둘째 줄의 수를 찾고 다시 그 수를 인덱스로 삼고를 반복
 * -> dfs
 * */

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[] nums;
	static boolean[] visited;
	static ArrayList<Integer> ans;
	
    public static void main(String[] args) throws IOException {
    	N = Integer.parseInt(input.readLine());
    	nums = new int[N+1];
    	visited = new boolean[N+1];
    	ans = new ArrayList<>();
    	
    	for(int i = 1; i <= N; i++) {
    		nums[i] = Integer.parseInt(input.readLine());
    	}
    	
    	for(int i = 1; i <= N; i++) {
    		visited[i] = true;
    		dfs(i, nums[i]);
    		Arrays.fill(visited, false);
    	}
    	
    	output.append(ans.size()).append("\n");
    	Collections.sort(ans);
    	
    	for(int n: ans) {
    		output.append(n).append("\n");
    	}
    	
    	System.out.println(output);
    }
    
    static void dfs(int start, int num) {
    	if(visited[num]) {
    		if(start == num) {
    			ans.add(num);
    		}
    		
    		return;
    	}
    	
    	visited[num] = true;
    	dfs(start, nums[num]);
    }
}