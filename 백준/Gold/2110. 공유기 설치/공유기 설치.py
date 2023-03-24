import sys
input = sys.stdin.readline

n, c = map(int, input().split())
home = [int(input()) for _ in range(n)]
home = sorted(home)
s = 0
e = home[-1]
ans = -1

while s <= e:
    mid = (s + e) // 2
    cnt = 1
    last = home[0]

    for i in range(n):
        now = home[i]

        if now - last >= mid:
            cnt += 1
            last = now

    if cnt < c:
        e = mid - 1
    else:
        ans = mid
        s = mid + 1

print(ans)