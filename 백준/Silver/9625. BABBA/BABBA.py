import sys
input = sys.stdin.readline

n = int(input())
dp = [(0, 0)] * (n+1)
dp[0] = (1, 0)

for i in range(1, n+1):
    dp[i] = (dp[i-1][1], dp[i-1][0] + dp[i-1][1])

print(*dp[n])