function solution(n) {
    var answer = 0;
    const dp = new Array(n+1).fill(0);
    
    dp[0] = 0;
    dp[1] = 1;

    for(let i = 2; i <= n; i++) {
        dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
    }
    
    console.log(dp)
    
    return dp[n] % 1234567;
}