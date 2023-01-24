import sys
input = sys.stdin.readline

num = int(input())
numbers = []

for i in range(num):
    n = int(input())
    if n == 0:
        numbers.pop(-1)
    else:
        numbers.append(n)

print(sum(numbers))