import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    day = int(input())
    cost = list(map(int, input().split()))
    max_cost = cost[-1]
    buy = ans = cnt = 0

    for i in reversed(range(day-1)):
        if max_cost > cost[i]:
            ans += max_cost - cost[i]
        else:
            max_cost = cost[i]

    print(ans)
