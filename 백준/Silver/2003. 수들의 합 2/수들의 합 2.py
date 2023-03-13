import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num = list(map(int, input().split()))
cnt = 0
s = 0
e = 0
tmp = 0

while s < n:
    if tmp >= m:
        tmp -= num[s]
        s += 1
    elif e == n:
        break
    else:
        tmp += num[e]
        e += 1

    if tmp == m:
        cnt += 1

print(cnt)