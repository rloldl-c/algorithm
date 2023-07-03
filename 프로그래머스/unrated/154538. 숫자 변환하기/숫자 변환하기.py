def solution(x, y, n):
    answer = -1
    dp = [int(1e9)] * (1000001)
    dp[x] = 0
    
    for i in range(x, y+1):
        if dp[y] != int(1e9):
            answer = dp[y]
            break
            
        for next in (i+n, i*2, i*3):
            if next > 1000000:
                continue
                
            dp[next] = min(dp[next], dp[i]+1)

    return answer