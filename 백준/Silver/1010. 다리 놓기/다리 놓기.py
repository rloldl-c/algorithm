import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    n, m = map(int, input().split())
    dp = [0] * (m+1)
    dp[0] = 1
    dp[1] = 1

    for i in range(2, m+1):
        dp[i] = dp[i-1]*i

    print(dp[m]//(dp[m-n]*dp[n]))