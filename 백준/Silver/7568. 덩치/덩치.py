import sys

num = int(sys.stdin.readline().strip())
numbers = []

for i in range(num):
    numbers.append(list(map(int, sys.stdin.readline().split())))

for i in range(num):
    rank = 1
    for j in range(num):
        if i == j:
            continue

        if numbers[i][0] < numbers[j][0] and numbers[i][1] < numbers[j][1]:
            rank += 1

    print(rank, end=" ")