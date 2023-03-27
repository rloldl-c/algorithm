import sys
input = sys.stdin.readline

n, m = map(int, input().split())
name = []
power = []

for _ in range(n):
    tmp = input().split()
    name.append(tmp[0])
    power.append(int(tmp[1]))

for _ in range(m):
    now = int(input())
    s = 0
    e = n
    ans = ''

    while s <= e:
        mid = int((s + e) / 2)

        if now > power[mid]:
            s = mid + 1
        else:
            ans = name[mid]
            e = mid - 1

    print(ans)