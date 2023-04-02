import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    n = int(input())
    dp = [0] * 10001
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    cnt = 1
    tmp = 3

    if n > 3:
        for i in range(4, n+1):
            dp[i] = dp[i-3] + tmp

            cnt += 1

            if cnt == 3:
                cnt = 1
                tmp += 1

    print(dp[n])