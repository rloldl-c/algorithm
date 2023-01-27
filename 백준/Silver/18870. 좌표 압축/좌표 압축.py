import sys
input = sys.stdin.readline

n = int(input())
numbers = list(map(int, input().split()))
sort_numbers = list(sorted(set(numbers)))
tmp = {}
for i in range(len(sort_numbers)):
    tmp[sort_numbers[i]] = i

for num in numbers:
    print(tmp[num], end=" ")