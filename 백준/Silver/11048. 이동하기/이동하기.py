import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maze = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if i == 0 and j == 0:
            dp[0][0] = maze[0][0]

        else:
            # 맨 위쪽
            if i == 0:
                dp[0][j] = maze[0][j] + dp[0][j-1]
            # 맨 왼쪽
            elif j == 0:
                dp[i][0] = maze[i][0] + dp[i-1][0]

            else:
                dp[i][j] = maze[i][j] + max(dp[i-1][j], dp[i][j-1])

print(dp[n-1][m-1])