import sys
input = sys.stdin.readline

n = list(map(int, input().strip()))

if 0 not in n:
    print(-1)
elif sum(n) % 3 != 0:
    print(-1)
else:
    n = sorted(n, reverse=True)
    print(*n, sep="")