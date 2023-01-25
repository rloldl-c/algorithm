import sys

input = sys.stdin.readline

num = int(input())
numbers = list(map(int, input().split()))
numbers = sorted(numbers)
total = [0] * num
total[0] = numbers[0]

for i in range(num-1):
    total[i+1] = total[i] + numbers[i+1]

print(sum(total))