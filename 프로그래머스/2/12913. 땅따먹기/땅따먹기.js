function solution(land) {
    let answer = 0;
    const N = land.length
    let dp = Array.from(Array(land.length), () => Array(4).fill(0))
    
    for(let i = 0; i < 4; i++) {
        dp[0][i] = land[0][i]
    }

    for(let i = 1; i < N; i++) {
        for(let j = 0; j < 4; j++) {
            let tmp = Array(4).fill(0)
            for(let k = 0; k < 4; k++) {
                if(j != k) {
                    tmp[k] = dp[i-1][k] + land[i][j]
                }
            }

            dp[i][j] = Math.max(...tmp)
        }
    }
    
    answer = Math.max(...dp[N-1])

    return answer;
}