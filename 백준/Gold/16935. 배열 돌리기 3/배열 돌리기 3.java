import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, R, order, arr[][], newArr[][];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		arr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		tokens = new StringTokenizer(input.readLine());

		for(int i = 0; i < R; i++) {
			order = Integer.parseInt(tokens.nextToken());
			
			switch (order) {
			case 1:
				upDownReverse();
				break;
			case 2:
				leftRightReverse();
				break;
			case 3:
				rotateRight();
				break;
			case 4:
				rotateLeft();
				break;
			case 5:
				moveClockwise();
				break;
			case 6:
				moveAnticlockwhise();
				break;
			}
			arr = newArr;
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				output.append(arr[r][c]).append(" ");
			}
			output.append("\n");
		}
		
		System.out.println(output);
	}
	
	static void upDownReverse() {
		newArr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				newArr[N-r-1][c] = arr[r][c];
			}
		}
	}
	
	static void leftRightReverse() {
		newArr = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				newArr[r][M-c-1] = arr[r][c];
			}
		}
	}
	
	static void rotateRight() {
		newArr = new int[M][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				newArr[c][N-r-1] = arr[r][c];
			}
		}
		
		int tmp = N;
		N = M;
		M = tmp;
	}
	
	static void rotateLeft() {
		newArr = new int[M][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				newArr[M-c-1][r] = arr[r][c];
			}
		}
		
		int tmp = N;
		N = M;
		M = tmp;
	}
	
	static void moveClockwise() {
		newArr = new int[N][M];

		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				newArr[r][c+M/2] = arr[r][c];
			}
		}

		for(int r = 0; r < N/2; r++) {
			for(int c = M/2; c < M; c++) {
				newArr[r+N/2][c] = arr[r][c];
			}
		}

		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				newArr[r][c-M/2] = arr[r][c];
			}
		}

		for(int r = N/2; r < N; r++) {
			for(int c = 0; c < M/2; c++) {
				newArr[r-N/2][c] = arr[r][c];
			}
		}
	}
	
	static void moveAnticlockwhise() {
		newArr = new int[N][M];

		for(int r = 0; r < N/2; r++) {
			for(int c = 0; c < M/2; c++) {
				newArr[r+N/2][c] = arr[r][c];
			}
		}

		for(int r = 0; r < N/2; r++) {
			for(int c = M/2; c < M; c++) {
				newArr[r][c-M/2] = arr[r][c];
			}
		}

		for(int r = N/2; r < N; r++) {
			for(int c = M/2; c < M; c++) {
				newArr[r-N/2][c] = arr[r][c];
			}
		}

		for(int r = N/2; r < N; r++) {
			for(int c = 0; c < M/2; c++) {
				newArr[r][c+M/2] = arr[r][c];
			}
		}
	}
}
