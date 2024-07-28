function solution(n, k) {
    const num = Array(n).fill(0).map((ele, idx) => idx+1)
    const answer = Array()
    const factorial= Array(n+1).fill(1)
    let nth = k-1
    
    for(let i = 2; i <= n; i++) {
        factorial[i] = factorial[i-1] * i
    }
    
    
    while(num.length) {        
        if(nth == 0) {
            answer.push(...num)
            break
        }
        
        const cycle = factorial[num.length-1]
        let idx = Math.floor(nth / cycle)

        answer.push(num[idx])
        nth = nth % cycle
        num.splice(idx, 1)
    }
    
    return answer;
}