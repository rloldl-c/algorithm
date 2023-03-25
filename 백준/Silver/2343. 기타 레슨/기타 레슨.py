import sys
input = sys.stdin.readline

n, m = map(int, input().split())
video = list(map(int, input().split()))
s = max(video)
e = sum(video)
ans = int(1e9)

while s <= e:
    mid = (s + e) // 2

    cnt = 1
    bluray = 0
    for i in range(n):
        bluray += video[i]

        if bluray > mid:
            cnt += 1
            bluray = video[i]

    if cnt > m:
        s = mid + 1
    else:
        ans = mid
        e = mid - 1

print(ans)