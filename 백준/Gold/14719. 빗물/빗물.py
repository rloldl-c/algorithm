import sys
input = sys.stdin.readline
c, r = map(int, input().split())
h = list(map(int, input().split()))
ans = 0
now = h[0]

for i in range(1, r-1):
    tmp = max(h[i:])
    if now > tmp:
        now = tmp

    if now > h[i]:
        ans += now - h[i]
    else:
        now = h[i]

print(ans)