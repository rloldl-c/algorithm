import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num = list(map(int, input().split()))
num_sum = [0]
tmp = 0

for i in num:
    tmp += i
    num_sum.append(tmp)

for _ in range(m):
    a, b = map(int, input().split())
    print(num_sum[b] - num_sum[a-1])