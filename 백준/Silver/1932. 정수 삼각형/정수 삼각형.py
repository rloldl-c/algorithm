import sys
input = sys.stdin.readline

n = int(input())
tri = [0] * n
dp = [[0] * i for i in range(1, n+1)]

for i in range(n):
    tri[i] = list(map(int, input().split()))

dp[0] = tri[0]

for i in range(1, n):
    for j in range(len(tri[i])):
        if j == 0:
            dp[i][j] = dp[i-1][j] + tri[i][j]
        elif j == len(tri[i])-1:
            dp[i][j] = dp[i-1][j-1] + tri[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1] + tri[i][j], dp[i-1][j] + tri[i][j])

print(max(dp[n-1]))