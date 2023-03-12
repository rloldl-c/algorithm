import sys
input = sys.stdin.readline

num = [int(input()) for _ in range(9)]
n = sum(num)
gap = n - 100
res = 0

for i in range(9):
    for j in range(i+1, 9):
        if i != j and num[i] + num[j] == gap:
            res = (i, j)
            break
    
    if res != 0:
        break

for i in range(9):
    if i not in res:
        print(num[i])