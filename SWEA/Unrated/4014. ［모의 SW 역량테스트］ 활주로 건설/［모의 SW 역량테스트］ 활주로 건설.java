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
//System.out.println(b);                                     // double 변수 1개 출력하는 예제
//System.out.println(g);                                     // char 변수 1개 출력하는 예제
//System.out.println(var);                             // 문자열 1개 출력하는 예제
//System.out.println(AB);                                // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
 
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
         
        for(int t = 0; t < T; t++) {
            output.append("#").append(t+1).append(" ");
            tokens = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(tokens.nextToken());
            int X = Integer.parseInt(tokens.nextToken());
            int[][] map = new int[N][N];
            int ans = 0;
             
            for(int r = 0; r < N; r++) {
                tokens = new StringTokenizer(input.readLine());
                for(int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(tokens.nextToken());
                }
            }
             
            for(int r = 0; r < N; r++) {
                boolean[] row = new boolean[N];
                boolean flag = true;
                for(int c = 0; c < N; c++) {
                    // 모든 조건을 만족한다면 활주로 건설 가능
                    if(c == N-1) {
                        ans++;
                        break;
                    }
                     
                    // 다음칸과 높이가 같다면 일단 진행
                    if(map[r][c] == map[r][c+1]) {
                        continue;
                    } else if(map[r][c+1] - map[r][c] == 1) { // 다음 칸이 한 칸 높다면
                        // 지나온 칸이 경사로 길이보다 짧으면 경사로 설치 불가능
                        if(c < X - 1) {
                            flag = false;
                            break;
                        }
 
                        // 이미 지나온 칸에 경사로를 설치할 수 있는지 확인
                        for(int i = c; i > c - X; i--) {
                            // 이미 경사로가 설치된 칸이면 설치 불가 & 활주로로 사용 X
                            if(row[i]) {
                                flag = false;
                                break;
                            }
                             
                            if(map[r][c+1] - map[r][i] != 1) {
                                flag = false;
                                break;
                            }
                             
                            row[i] = true;
                        }
                         
                        if(!flag) break;
                         
                    } else if(map[r][c] - map[r][c+1] == 1) { // 다음 칸이 한 칸 낮다면
                        // 남은 칸이 경사로 길이보다 짧다면 경사로 설치 불가
                        if(N - c - 1 < X) {
                            flag = false;
                            break;
                        }
                         
                        // 다음 칸에 경사로를 설치할 수 있는지 확인
                        for(int i = c+1; i <= c + X; i++) {
                            if(row[i]) {
                                flag = false;
                                break;
                            }
                             
                            if(map[r][c] - map[r][i] != 1) {
                                flag = false;
                                break;
                            }
                             
                            row[i] = true;
                        }
                         
                        if(!flag) break;
                    } else { // 칸 차이가 1칸 이상이면 활주로로 활용 불가능
                        break;
                    }
                }
            }
             
            for(int c = 0; c < N; c++) {
                boolean[] col = new boolean[N];
                boolean flag = true;
                for(int r = 0; r < N; r++) {
                    // 모든 조건을 만족한다면 활주로 건설 가능
                    if(r == N-1) {
                        ans++;
                        break;
                    }
                     
                    // 다음칸과 높이가 같다면 일단 진행
                    if(map[r][c] == map[r+1][c]) {
                        continue;
                    } else if(map[r+1][c] - map[r][c] == 1) { // 다음 칸이 한 칸 높다면
                        // 지나온 칸이 경사로 길이보다 짧으면 경사로 설치 불가능
                        if(r < X - 1) {
                            flag = false;
                            break;
                        }
 
                        // 이미 지나온 칸에 경사로를 설치할 수 있는지 확인
                        for(int i = r; i > r - X; i--) {
                            // 이미 경사로가 설치된 칸이면 설치 불가 & 활주로로 사용 X
                            if(col[i]) {
                                flag = false;
                                break;
                            }
                             
                            if(map[r+1][c] - map[i][c] != 1) {
                                flag = false;
                                break;
                            }
                             
                            col[i] = true;
                        }
                         
                        if(!flag) break;
                         
                    } else if(map[r][c] - map[r+1][c] == 1) { // 다음 칸이 한 칸 낮다면
                        // 남은 칸이 경사로 길이보다 짧다면 경사로 설치 불가
                        if(N - r - 1 < X) {
                            flag = false;
                            break;
                        }
                         
                        // 다음 칸에 경사로를 설치할 수 있는지 확인
                        for(int i = r+1; i <= r + X; i++) {
                            if(col[i]) {
                                flag = false;
                                break;
                            }
                             
                            if(map[r][c] - map[i][c] != 1) {
                                flag = false;
                                break;
                            }
                             
                            col[i] = true;
                        }
                         
                        if(!flag) break;
                    } else { // 칸 차이가 1칸 이상이면 활주로로 활용 불가능
                        break;
                    }
                }
            }
             
            output.append(ans).append("\n");
        }
 
        System.out.println(output);
    }
}