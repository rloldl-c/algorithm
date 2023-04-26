import sys
input = sys.stdin.readline

n = int(input())
top = list(map(int, input().split()))
height = [(0, top[0])]
idx = 0

for i in range(n):
    if height:
        while height:
            if top[i] < height[-1][1]:
                print(height[-1][0]+1, end=" ")
                break

            height.pop()

    if not height:
        print(0, end=" ")

    height.append((i, top[i]))