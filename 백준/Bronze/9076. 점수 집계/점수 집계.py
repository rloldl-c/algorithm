import sys

input = sys.stdin.readline

n = int(input())

for _ in range(n):
    numbers = list(map(int, input().split()))
    numbers = sorted(numbers)

    if numbers[-2] - numbers[1] >= 4:
        print("KIN")
    else:
        print(sum(numbers[1:-1]))