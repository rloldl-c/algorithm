import sys
input = sys.stdin.readline

n = int(input())
num = [int(input()) for _ in range(n)]
num = sorted(num, reverse=True)
res = [0] * n
cnt = 0

for i in range(n):
    res[i] = num[i] * (i+1)

print(max(res))