import sys
input = sys.stdin.readline

n = int(input())
info = {}

for _ in range(n):
    name, d, m, y = input().split()
    info[name] = tuple(map(int, (d, m, y)))

info = sorted(info.items(), key=lambda x: (x[1][2], x[1][1], x[1][0]))

print(info[n-1][0], info[0][0], sep="\n")