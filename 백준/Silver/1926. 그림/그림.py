import sys
input = sys.stdin.readline

def bfs(x, y):
    stack = [(x, y)]
    paper[x][y] = 0
    cnt = 0

    while stack:
        cnt += 1
        x, y = stack.pop()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if paper[nx][ny] == 0:
                continue
            if paper[nx][ny] == 1:
                paper[nx][ny] = 0
                stack.append((nx, ny))
    
    return cnt


n, m = map(int, input().split())
paper = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(n):
    paper.append(list(map(int, input().split())))

res = []

for i in range(n):
    for j in range(m):
        if paper[i][j] == 1:
           res.append(bfs(i, j))

if res:
    print(len(res), max(res), sep="\n")
else:
    print(0, 0, sep="\n")