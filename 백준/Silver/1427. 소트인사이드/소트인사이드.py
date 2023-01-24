import sys
input = sys.stdin.readline

num = input().strip()
numbers = [int(n) for n in num]
descending = sorted(numbers, reverse=True)

print(*descending, sep="")
