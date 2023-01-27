import sys
input = sys.stdin.readline

numbers = {}

for _ in range(10):
    n = int(input()) % 42

    if n not in numbers:
        numbers[n] = 1

print(len(numbers))