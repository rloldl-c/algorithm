import sys
input = sys.stdin.readline

num = input().strip()
numbers = [0] * 10
cnt = 0

for i in range(10):
    rep = num.count(str(i))
    if rep > 0:
        if i == 9:
            numbers[6] += rep
        else:
            numbers[i]+= rep

if numbers[6] % 2 == 0:
    numbers[6] = numbers[6] // 2
else:
    numbers[6] = numbers[6] // 2 + 1

print(max(numbers))