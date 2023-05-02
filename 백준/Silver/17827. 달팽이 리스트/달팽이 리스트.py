import sys
input = sys.stdin.readline

n, m, v = map(int, input().split())
snail = list(map(int, input().split()))

for _ in range(m):
    k = int(input())

    if k < n:
        print(snail[k])
        continue

    k -= v - 1
    tmp = snail[v-1:]
    k %= len(tmp)

    print(tmp[k])