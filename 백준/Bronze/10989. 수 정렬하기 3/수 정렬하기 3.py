import sys

n = int(sys.stdin.readline().strip())
num_list = [0] * 10001

for i in range(n):
    num_list[int(sys.stdin.readline().strip())] += 1

for i in range(10001):
    for j in range(num_list[i]):
        print(i)