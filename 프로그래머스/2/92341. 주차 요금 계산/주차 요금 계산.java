import java.util.*;

class Solution {
    // fees [기본 시간, 기본 요금, 단위 시간, 단위 요금]
    // 출차 시간이 없으면 23:59에 출차한 것으로 간주
    // 단위 시간으로 나누어 떨어지지 않을 경우 올림
    // 차량 번호가 작은 자동차부터 출력
    public int[] solution(int[] fees, String[] records) {
        int[][] cars = new int[10000][3]; // [누적 시간, 입차 시간, 0시 전에 출차했는가]
        ArrayList<Integer> carList = new ArrayList<>();
        
        for(int i = 0; i < records.length; i++) {
            int time = Integer.parseInt(records[i].substring(0, 2)) * 60 + Integer.parseInt(records[i].substring(3, 5));
            int carNum = Integer.parseInt(records[i].substring(6, 10));
            String status = records[i].substring(11);
            
            if(carList.indexOf(carNum) < 0) {
                carList.add(carNum);
            }

            // 입차일 경우
            if(status.equals("IN")) {
                cars[carNum][1] = time;
                cars[carNum][2] = 1;
            } else {
                // 출차 시간 - 입차 시간
                cars[carNum][0] += time - cars[carNum][1];
                cars[carNum][1] = 0;
                cars[carNum][2] = 0;
            }
        }
        
        // 차량 번호 정렬
        Collections.sort(carList);
        int[] answer = new int[carList.size()];
        
        for(int i = 0; i < carList.size(); i++) {
            int num = carList.get(i);

            // 0시 전에 출차하지 않았다면
            if(cars[num][2] != 0) {
                cars[num][0] += 1439 - cars[num][1];
            }
            
            // 기본 시간을 초과한다면
            if(cars[num][0] > fees[0]) {
                // 초과 시간 계산
                int overTime = (int)Math.ceil((cars[num][0] - fees[0]) / (float)fees[2]);
                int cost = overTime * fees[3];
                
                answer[i] = fees[1] + cost;
            } else {
                answer[i] = fees[1];
            }
        }
        
        return answer;
    }
}