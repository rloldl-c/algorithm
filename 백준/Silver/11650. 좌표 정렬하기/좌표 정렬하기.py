import sys

num = int(sys.stdin.readline().strip())
numbers = []

for i in range(num):
    numbers.append(list(map(int, sys.stdin.readline().split())))

numbers.sort()

for i in numbers:
    print(*i)