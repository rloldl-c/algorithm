import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt = 1;
        for(int i = 0; i < tangerine.length; i++) {
            if(i > 0 && tangerine[i] == tangerine[i-1]) {
                cnt++;
                
                if(i == tangerine.length - 1) {
                    que.add(cnt);
                }
            } else {
                que.add(cnt);
                cnt = 1;
            }
        }

        int total = 0;
        
        while(!que.isEmpty()) {
            int now = que.poll();
            
            total += now;
            answer++;
            
            if(total >= k) {
                break;
            }
        }
        
        return answer;
    }
}