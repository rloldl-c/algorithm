import sys
input = sys.stdin.readline

n = int(input())
col = []
max_ = 0

for _ in range(n):
    a, b = map(int, input().split())
    col.append((a, b))

col = sorted(col)

for i in range(n):
    if max(col, key=lambda x: x[1])[1] == col[i][1]:
        max_ = i
        break

ans = 0

tmp = col[0][1]
for i in range(max_):
    ans += tmp * (col[i+1][0] - col[i][0])

    if tmp < col[i+1][1]:
        tmp = col[i+1][1]

tmp = col[-1][1]
for i in range(n-1, max_, -1):
    ans += tmp * (col[i][0] - col[i-1][0])

    if tmp < col[i-1][1]:
        tmp = col[i-1][1]

print(ans + col[max_][1])

