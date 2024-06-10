function solution(msg) {
    let answer = [];
    const index = [''];
    
    for(let i = 1; i < 27; i++) {
        index.push(String.fromCharCode(64+i));
    }
    
    let now = 0;
    for(let i = 1; i <= msg.length; i++) {
        while(true) {
            if(index.includes(msg.slice(now, i+1))) {
                i++;
                
                if(i > msg.length) {
                    answer.push(index.indexOf(msg.slice(now, i)));
                    break;
                }
            } else {
                const next = msg.slice(now, i);
                answer.push(index.indexOf(next));
                index.push(msg.slice(now, i+1));
                now = i;
                break;
            }
        }
    }

    return answer;
}