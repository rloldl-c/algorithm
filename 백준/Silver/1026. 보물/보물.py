import sys

input = sys.stdin.readline

num = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a = sorted(a)
b = sorted(b, reverse=True)
total = 0

for i in range(num):
    total += a[i] * b[i]

print(total)