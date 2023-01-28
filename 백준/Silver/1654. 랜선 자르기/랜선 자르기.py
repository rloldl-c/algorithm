import sys
input = sys.stdin.readline

k, n = map(int, input().split())
lines = [int(input()) for _ in range(k)]
lines.sort()

s = 1
e = lines[-1]
max_len = 0

while s <= e:
    mid = (s + e) // 2

    num = 0

    for line in lines:
        num += line // mid

    if num >= n:
        max_len = max(max_len, mid)
        s = mid + 1
    elif num < n:
        e = mid - 1
        

print(max_len)

