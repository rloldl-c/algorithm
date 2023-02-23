import sys
input = sys.stdin.readline

n = int(input())
table = [[0] * n for _ in range(n)]
target = int(input())
dxy = [(1, 0) ,(0, 1), (-1, 0), (0, -1)]
num = n*n
x = y = idx = 0
res = 0

while num != 0:
    table[x][y] = num

    if target == num:
        res = (x+1, y+1)

    if x + dxy[idx][0] < 0 or x + dxy[idx][0] >= n or y + dxy[idx][1] < 0 or y + dxy[idx][1] >= n or table[x + dxy[idx][0]][y + dxy[idx][1]] != 0:
        idx = (idx + 1)%4

    x += dxy[idx][0]
    y += dxy[idx][1]
    num -= 1

for i in table:
    print(*i)

print(*res)