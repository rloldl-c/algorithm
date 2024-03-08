import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(input.readLine());
		
		int[][] map = new int[N][3];
		int[] dpMin = new int[3];
		int[] dpMax = new int[3];
		
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		dpMax[0] = map[0][0];
		dpMin[0] = map[0][0];
		
		dpMax[1] = map[0][1];
		dpMin[1] = map[0][1];
		
		dpMax[2] = map[0][2];
		dpMin[2] = map[0][2];
		
		for(int i = 1; i < N; i++) {
			int prevMax0 = dpMax[0];
			int prevMax2 = dpMax[2];
			int prevMin0 = dpMin[0];
			int prevMin2 = dpMin[2];
			
			dpMax[0] = map[i][0] + Math.max(dpMax[0], dpMax[1]);
			dpMin[0] = map[i][0] + Math.min(dpMin[0], dpMin[1]);
			
			dpMax[2] = map[i][2] + Math.max(dpMax[2], dpMax[1]);
			dpMin[2] = map[i][2] + Math.min(dpMin[2], dpMin[1]);
			
			dpMax[1] = map[i][1] + Math.max(Math.max(prevMax0, dpMax[1]), prevMax2);
			dpMin[1] = map[i][1] + Math.min(Math.min(prevMin0, dpMin[1]), prevMin2);
		}
		
		System.out.println(Math.max(Math.max(dpMax[0], dpMax[1]), dpMax[2]) + " " + Math.min(Math.min(dpMin[0], dpMin[1]), dpMin[2]));
	}
}