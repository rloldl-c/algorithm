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
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int N, M;
    static boolean[][] graph;
 
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
 
        for(int t = 0; t < T; t++) {
            output.append("#").append(t+1).append(" ");
            N = Integer.parseInt(input.readLine());
            M = Integer.parseInt(input.readLine());
            graph = new boolean[N+1][N+1];
            int ans = 0;
             
            for(int m = 0; m < M; m++) {
                tokens = new StringTokenizer(input.readLine());
                int from = Integer.parseInt(tokens.nextToken());
                int to = Integer.parseInt(tokens.nextToken());
                graph[from][to] = true;
            }
             
            for(int i = 1; i < N+1; i++) {
                int cnt = tallBfs(i) + shortBfs(i);
 
                if(cnt == N-1) {
                    ans++;
                }
            }
             
            output.append(ans).append("\n");
        }
         
        System.out.println(output);
    }
     
    static int tallBfs(int from) {
        int cnt = 0;
        Deque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
         
        for(int i = 1; i < N+1; i++) {
            if(graph[from][i]) {
                que.offer(i);
                visited[i] = true;
                cnt++;
            }
        }
         
        while(!que.isEmpty()) {
            int now = que.poll();
             
            for(int i = 1; i < N+1; i++) {
                if(graph[now][i] && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
         
        return cnt;
    }
     
    static int shortBfs(int to) {
        int cnt = 0;
        Deque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];
 
        for(int i = 1; i < N+1; i++) {
            if(graph[i][to]) {
                que.offer(i);
                visited[i] = true;
                cnt++;
            }
        }
         
        while(!que.isEmpty()) {
            int now = que.poll();
             
            for(int i = 1; i < N+1; i++) {
                if(graph[i][now] && !visited[i]) {
                    que.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
         
        return cnt;
    }
}