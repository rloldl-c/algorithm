import sys
input = sys.stdin.readline

num = int(input().strip())
paper = [[0 for i in range(101)] for j in range(101)]
total = 0

for i in range(num):
    a, b = map(int, input().split())
    for k in range(10):
        for l in range(10):
            paper[a+k][b+l] = 1

for i in range(101):
    total += sum(paper[i])

print(total)