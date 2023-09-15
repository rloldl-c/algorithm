/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, M, K;
	static int[][] map, deltas;
	static List<Micro> micros;
    
    public static class Micro {
		int r;
		int c;
		int cnt;
		int d;
		boolean status = true; // true: 존재 / false: 존재 X
		
		public Micro(int r, int c, int cnt, int d) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}
	}
    
	public static void main(String args[]) throws Exception
	{
		deltas = new int[][] {{}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int T = Integer.parseInt(input.readLine());
		
		for(int t = 0; t < T; t++) {
			// 구역 만들기
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			map = new int[N][N];
			
			// 미생물 정보 입력받기
			micros = new ArrayList<>();
			
			for(int i = 0; i < K; i++) {
				tokens = new StringTokenizer(input.readLine());
				int r = Integer.parseInt(tokens.nextToken());
				int c = Integer.parseInt(tokens.nextToken());
				int cnt = Integer.parseInt(tokens.nextToken());
				int d = Integer.parseInt(tokens.nextToken());
				
				micros.add(new Micro(r, c, cnt, d));
				map[r][c]++;
			}
			
			while(--M >= 0) {
				for(int i = 0; i < K; i++) {
					if(micros.get(i).status) {					
						// 군집 이동
						move(i);
					}
				}
				
				// 각 칸에 두 개 이상의 군집이 있는지 확인
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(map[r][c] >= 2) {
							join(r, c);
						}
					}
				}
				
			}
			int res = 0;
			
			for(Micro m: micros) {
				if(m.status) {				
					res += m.cnt;
				}
			}
			
			output.append("#").append(t+1).append(" " + res + "\n");
		}
		
		System.out.println(output);
	}
	
	static void join(int r, int c) {
		List<Integer> tmp = new ArrayList<>();

		for(int i = 0; i < K; i++) {
			if(r == micros.get(i).r && c == micros.get(i).c && micros.get(i).status) {
				tmp.add(i);
			}
		}
		
		int total = 0; // 총 미생물 수
		int max = -1; // 가장 많은 미생물을 가진 군집 번호
		
		for(int i = 0; i < tmp.size(); i++) {
			int now = tmp.get(i);
			
			total += micros.get(now).cnt;
			
			if(max < 0) {
				max = now;
				continue;
			}
			
			if(micros.get(max).cnt < micros.get(now).cnt) {
				// 가장 많은 미생물을 가진 군집이 아니면 사라짐
				micros.get(max).status = false;
				max = now;
				map[r][c]--;
			} else {
				micros.get(now).status = false;
			}
		}

		micros.get(max).cnt = total;
		map[micros.get(max).r][micros.get(max).c] = 1;
	}
	
	static void move(int i) {
		int r = micros.get(i).r;
		int c = micros.get(i).c;
		int d = micros.get(i).d;
		int nr = r + deltas[d][0];
		int nc = c + deltas[d][1];
		micros.get(i).r = nr;
		micros.get(i).c = nc;		
		map[r][c]--;
		map[nr][nc]++;
		
		// 가장자리로 이동하면 방향 바꾸고 미생물 수 줄이기
		if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
			if(d == 1) micros.get(i).d = 2;
			else if (d == 2) micros.get(i).d = 1;
			else if (d == 3) micros.get(i).d = 4;
			else if (d == 4) micros.get(i).d = 3;
			
			micros.get(i).cnt /= 2;
			
			// 미생물 수가 0이 되면 사라짐
			if(micros.get(i).cnt == 0) {
				micros.get(i).status = false;
			}
		}
	}
}