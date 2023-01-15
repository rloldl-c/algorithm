import sys

num = int(sys.stdin.readline().strip())
numbers = []

for i in range(num):
    a, b = map(int, sys.stdin.readline().split())
    numbers.append([b, a])

numbers.sort()

for i in range(num):
    print(numbers[i][1], numbers[i][0])