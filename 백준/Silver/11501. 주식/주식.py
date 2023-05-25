import sys
input = sys.stdin.readline

def main():
    t = int(input())
    for _ in range(t):
        day = int(input())
        cost = list(map(int, input().split()))
        max_cost = cost[-1]
        ans = 0

        for i in reversed(range(day-1)):
            if max_cost > cost[i]:
                ans += max_cost - cost[i]
            else:
                max_cost = cost[i]

        print(ans)


if __name__ == '__main__':
    main()