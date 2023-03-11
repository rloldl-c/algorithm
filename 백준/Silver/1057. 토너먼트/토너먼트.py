import sys
input = sys.stdin.readline

n, jm, hs = map(int, input().split())
cnt = 1
breaker = False

while not breaker:

    for i in range(1, n+1, 2**cnt):
        # print(i, (i+2**cnt)-1)

        if i <= jm <= (i+2**cnt)-1 and i <= hs <= (i+2**cnt)-1:
            breaker = True
            break

    cnt += 1

print(cnt-1)