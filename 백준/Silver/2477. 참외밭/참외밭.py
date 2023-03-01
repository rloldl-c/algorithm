import sys
input = sys.stdin.readline

n = int(input())
field = [(0, 0)] * 6 
cnt = [0] * 5
total = 1
sub = 1

for i in range(6):
    direction, length = map(int, input().split())
    field[i] = (direction, length)
    cnt[direction] += 1

for i in range(6):
    if cnt[field[i][0]] == 1:
        total *= field[i][1]
    else:
        if field[i][0] == field[(i+2)%6][0]:
            sub *= field[(i+1)%6][1]

print((total - sub) * n)