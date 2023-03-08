import sys
input = sys.stdin.readline

a, b = map(int, input().split())
c, d = map(int, input().split())
prime = [1] * 1001

for i in range(2, int((1000)**0.5)+1):
    if prime[i] == 1:
        for j in range(i+i, 1001, i):
            prime[j] = 0

if b >= c:
    tmp = sum(prime[c:b+1])
else:
    tmp = 0

yt = sum(prime[a:b+1]) - tmp
yj = sum(prime[c:d+1]) - tmp

if tmp % 2 == 0:
    if yt > yj:
        print("yt")
    else:
        print("yj")
else:
    if yt >= yj:
        print("yt")
    else:
        print("yj")