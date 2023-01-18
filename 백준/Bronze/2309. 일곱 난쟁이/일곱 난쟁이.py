# import sys
# sys.stdin = open("input.txt", "r")

height = [0 for i in range(9)]
seven = []

for i in range(9):
    height[i] = int(input())

gap = sum(height) - 100
idx1 = 0
idx2 = 0

for i in range(8):
    for j in range(i+1, 9):
        if height[i] + height[j] == gap:
            idx1 = i
            idx2 = j
            break

for i in range(9):
    if i == idx1:
        continue
    elif i == idx2:
        continue
    else:
        seven.append(height[i])

seven.sort()

for i in range(7):
    print(seven[i])
