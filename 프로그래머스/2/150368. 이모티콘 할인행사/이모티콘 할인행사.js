function solution(users, emoticons) {
    let answer = [0, 0];
    
    function combi(sales, nth) {
        if(nth == emoticons.length) {
            event(sales);
            return;
        }
        
        for(let i = 1; i < 5; i++) {
            sales.push(i * 10);
            combi(sales, nth+1);
            sales.pop();
        }
    }
    
    function event(sales) {
        let plus = 0;
        let total = 0;

        for(const user of users) {
            let cost = 0;
            
            for(let i = 0; i < sales.length; i++) {
                if(user[0] <= sales[i]) {
                    cost += Math.round(emoticons[i] * (1 - sales[i] / 100));
                }
                
                if(cost >= user[1]) {
                    plus++;
                    break
                }
            }
            
            if(cost < user[1]) {
                total += cost;
            }
        }
        
        if(answer[0] < plus) {
            answer[0] = plus;
            answer[1] = total;
        } else if(answer[0] == plus) {
            answer[1] = Math.max(answer[1], total);
        }
    }
    
    combi([], 0);
    
    return answer;
}