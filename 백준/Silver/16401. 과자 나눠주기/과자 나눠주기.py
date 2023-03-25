import sys
input = sys.stdin.readline

n, m = map(int, input().split())
snack = list(map(int, input().split()))
s = 1
e = max(snack)
ans = 0

while s <= e:
    mid = (s + e) // 2
    cnt = 0

    for i in snack:
        cnt += i // mid

    if cnt >= n:
        s = mid + 1
        ans = mid
    else:
        e = mid - 1

print(ans)