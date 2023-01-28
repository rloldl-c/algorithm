import sys
input = sys.stdin.readline

n = int(input())
cnt = 0

def fib(n):
    if n == 1 or n == 2:
        return 1
    return fib(n - 1) + fib(n - 2)


d = [0] * (n+1)
d[1] = d[2] = 1

for i in range(3, n+1):
    cnt += 1
    d[i] = d[i-1] + d[i-2]

print(fib(n), cnt)