import sys
input = sys.stdin.readline

n, m = map(int, input().split())
time = sorted(list(map(int, input().split())))
s = 1
e = min(time) * m
ans = 0

while s <= e:
    mid = int((s + e) / 2)
    tmp = 0 # mid 시간 동안 만들 수 있는 풍선 수

    for i in time:
        tmp += mid // i

    if tmp < m:
        s = mid + 1
    else:
        ans = mid
        e = mid - 1

print(ans)
