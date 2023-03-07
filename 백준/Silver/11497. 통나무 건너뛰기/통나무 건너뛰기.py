import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    n = int(input())
    tree = sorted(list(map(int, input().split())))
    tmp = [0] * n
    ans = 0
    l = 0
    r = n - 1

    for i in range(n):
        if i % 2 == 0:
            tmp[l] = tree[i]
            l += 1
        else:
            tmp[r] = tree[i]
            r -= 1

    for i in range(1, n):
        ans = max(ans, abs(tmp[i-1]-tmp[i]))

    print(ans)