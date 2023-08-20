import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		// 입력으로 주어지는 행렬 입력 받기
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		// 풀링 적용시키는 메서드 호출
		square(map, N);
		
		System.out.println(ans);

	}
	
	static void square(int[][] map, int len) {
		// 1x1 크기로 줄어들면 원소 출력하고 메서드 종료
		if(len == 1) {
			ans = map[0][0];
			return;
		}
		
		// 새로운 행렬은 크기가 절반으로 줄어듦
		int now = len/2;
		// 줄어든 크기로 새로운 행렬 만들기
		int[][] newMap = new int[now][now];
		int nr = 0;
		int nc = 0;
		
		for(int r = 0; r < len; r+=2) {
			nc = 0;
			for(int c= 0; c < len; c+=2) {
				// 새로운 행렬에 기존 행렬에서 두번째로 큰 수 입력
				newMap[nr][nc++] = secondNumber(map, r, c);
			}
			nr++;
		}
		
		// 사각형의 크기가 1이 될 때까지 반복
		square(newMap, now);
		
	}
	
	// 2x2 사각형에서 두번째로 큰 수를 찾는 메서드
	static int secondNumber(int[][] map, int r, int c) {
		int[] tmp = new int[4];
		int idx = 0;
		
		// 2x2 사각형에 있는 원소들을 1차원 배열에 담고
		for(int nr = r; nr < r+2; nr++) {
			for(int nc = c; nc < c+2; nc++) {
				tmp[idx++] = map[nr][nc];
			}
		}
		
		// 정렬
		Arrays.sort(tmp);
		
		// 오름차순으로 정렬되었기 때문에 뒤에서 두번째 수 출력
		return tmp[2];
	}

}