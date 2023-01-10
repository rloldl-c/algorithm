num = int(input())
numbers = list(map(int, input().split()))
numbers = sorted(numbers)

print(numbers[num//2])