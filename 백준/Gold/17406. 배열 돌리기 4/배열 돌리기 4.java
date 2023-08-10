/**
* @author 은비
* @since
* @see https://www.acmicpc.net/problem/17406
* @performance
* @category #구현 #순열
* @note 
* K개의 연산은 조합으로 순서 정하기
* 순서가 바뀔 때마다 바뀐 연산으로 회전 수행
* 가장 겉 테두리를 4개의 1차원 배열로 보고 한 칸씩 옮겨주기
* 안쪽으로 들어오면 옮기는 칸 수를 한 칸씩 늘려서 회전해줘야 함
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, K, min, arr[][], oper[][];

	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		min = Integer.MAX_VALUE; // 최소값을 저장할 변수
		arr = new int[N][M]; // 원본 배열
		oper = new int[K][3]; // 연산 정보를 저장할 배열
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}

		// 연산 정보 입력 받기
		for(int r = 0; r < K; r++) {
			tokens = new StringTokenizer(input.readLine());
			oper[r][0] = Integer.parseInt(tokens.nextToken()) - 1;
			oper[r][1] = Integer.parseInt(tokens.nextToken()) - 1;
			oper[r][2] = Integer.parseInt(tokens.nextToken());
		}
		
		// 입력된 연산 정보 순서를 순열로 바꿔주면서 회전
		makeOperCombi(0, new int[K], new boolean[K]);
		
		System.out.println(min);
	}

	static void makeOperCombi(int cnt, int[] res, boolean[] visited) {
		if(cnt == K) {
			// 연산 순서가 정해지면 회전시키기
			rotate(res);
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(!visited[i]) {
				res[cnt] = i;
				visited[i] = true;
				makeOperCombi(cnt+1, res, visited);
				visited[i] = false;
			}
		}
	}
	
	static void rotate(int[] res) {
		int[][] tmp = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				tmp[r][c] = arr[r][c];
			}
		}
		
		for(int i = 0; i < res.length; i++) {
			int r = oper[res[i]][0];
			int c = oper[res[i]][1];
			int S = oper[res[i]][2];

			for(int s = 1; s <= S; s++) {
				// 위쪽 1줄 회전
				int up = tmp[r-s][c+s];
                for(int nc = c+s; nc > c-s; nc--) {
                    tmp[r-s][nc] = tmp[r-s][nc-1];
                }
                
                //오른쪽 1줄 회전
                int right = tmp[r+s][c+s];
                for(int nr = r+s; nr > r-s; nr--) {
                    tmp[nr][c+s] = tmp[nr-1][c+s];
                }
                tmp[r-s+1][c+s] = up;
                
                //아래쪽 1줄 회전
                int left = tmp[r+s][c-s];
                for(int nc = c-s; nc < c+s; nc++) {
                    tmp[r+s][nc] = tmp[r+s][nc+1];
                }
                tmp[r+s][c+s-1] = right;
                
                //왼쪽 1줄 회전
                for(int nr = r-s; nr < r+s; nr++) {
                    tmp[nr][c-s] = tmp[nr+1][c-s];
                }
                tmp[r+s-1][c-s] = left;
			}
		}
		
		calMin(tmp);
	}
	
	static void calMin(int[][] tmp) {
		for(int r = 0; r < N; r++) {
			int sum = 0;
			for(int c = 0; c < M; c++) {
				sum += tmp[r][c];
			}
			
			if(min > sum) {
				min = sum;
			}
		}
	}
}
