import sys
input = sys.stdin.readline

a, b = map(int, input().split())
cnt = 1

while True:
    if a >= b:
        break

    if b % 10 == 1:
        cnt += 1
        b //= 10

    elif b % 2 == 0:
        cnt += 1
        b //= 2

    else:
        break

if a != b:
    cnt = -1

print(cnt)