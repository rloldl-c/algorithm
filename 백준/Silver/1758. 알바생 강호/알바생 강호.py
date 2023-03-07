import sys
input = sys.stdin.readline

n = int(input())
tip = sorted([int(input()) for _ in range(n)], reverse=True)
ans = 0

for i in range(n):
    tmp = tip[i] - i

    if tmp > 0:
        ans += tmp

print(ans)