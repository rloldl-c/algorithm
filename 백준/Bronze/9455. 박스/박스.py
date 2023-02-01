import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    row, col = map(int, input().split())
    grid = []
    cnt = 0
    
    for __ in range(row):
        grid.append(list(map(int, input().split())))
        
    for i in range(col):
        box = 0
        for j in range(row):
            if grid[j][i] == 1:
                box += 1
                cnt += row - j - box

    print(cnt)
