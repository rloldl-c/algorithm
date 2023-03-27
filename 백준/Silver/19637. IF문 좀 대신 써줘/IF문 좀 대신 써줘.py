# 42036KB / 800ms

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
name = []
power = []

for i in range(n):
    tmp = input().split()
    if power and power[-1] == int(tmp[1]):
        continue
    name.append(tmp[0])
    power.append(int(tmp[1]))

for _ in range(m):
    now = int(input())
    s = 0
    e = len(power)
    ans = ''

    while s <= e:
        mid = int((s + e) / 2)

        if now > power[mid]:
            s = mid + 1
        else:
            ans = name[mid]
            e = mid - 1

    print(ans)