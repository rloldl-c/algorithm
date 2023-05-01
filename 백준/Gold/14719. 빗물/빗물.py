import sys
input = sys.stdin.readline

c, r = map(int, input().split())
block = list(map(int, input().split()))
ans = 0
now = block[0]

for i in range(1, r-1):
    if now > max(block[i:]):
        now = max(block[i:])

    if block[i] < now:
        ans += now - block[i]
    else:
        now = block[i]

print(ans)