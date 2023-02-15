test = int(input())

for _ in range(test):
    n = int(input())
    dp = [0] * (n+1)
    dp[0] = 1

    if n > 0:
        for i in range(1, n):
            if i == 1:
                dp[i] = 2
            elif i == 2:
                dp[i] = 4
            else:
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

    print(dp[n-1])