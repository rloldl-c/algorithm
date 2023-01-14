import sys

num = int(sys.stdin.readline().strip())
numbers = []


for i in range(num):
    n = int(sys.stdin.readline().strip())
    numbers.append(n)

numbers.sort()

for num in numbers:
    print(num)