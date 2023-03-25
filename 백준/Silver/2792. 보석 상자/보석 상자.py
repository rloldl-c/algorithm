import sys
input = sys.stdin.readline

n, m = map(int, input().split())
jewel = [int(input()) for _ in range(m)]
s = 1
e = max(jewel)
ans = 0

while s <= e:
    mid = (s + e) // 2
    cnt = 0

    for i in range(m):
        if jewel[i] % mid == 0:
            cnt += (jewel[i] // mid)
        else:
            cnt += (jewel[i] // mid + 1)

    if cnt > n:
        s = mid + 1
    else:
        ans = mid
        e = mid - 1

print(ans)