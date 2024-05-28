function solution(storey) {
    let answer = 9999999;
    let q = [];
    q.push(new Entry(storey, 0, 0));
    for (let t = 0; t < 10000 && q.length > 0; t++) {
        const e = q.shift();
        if (e.storey === 0) {
            answer = Math.min(answer, e.count)
        }
        const digit10 = pow10(e.nextDigit);
        const digit = Math.floor((e.storey / digit10) % 10)
        
        if (digit === 0) {
            q.push(new Entry(
            e.storey,
            e.nextDigit + 1,
            e.count))
            continue;
        }
        // down
        {
            let moreCount = digit;
            q.push(new Entry(
                e.storey - moreCount * digit10,
                e.nextDigit + 1,
                e.count + moreCount));
        }
        // up
        {
            let moreCount = 10 - digit;
            q.push(new Entry(
                e.storey + moreCount * digit10,
                e.nextDigit + 1,
                e.count + moreCount));
        }
    }
    
    return answer;
}

function pow10(n) {
    let a = 1;
    for (let i = 0; i < n; i++) {
        a *= 10;
    }
    return a;
}

class Entry {
    count = 0;
    storey = 0;
    nextDigit = 0;
    
    constructor(storey, nextDigit, count) {
        this.count = count;
        this.storey = storey;
        this.nextDigit = nextDigit;
    }
}