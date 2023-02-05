import sys
from collections import deque
input = sys.stdin.readline

def search(x, y):
    que = deque()
    que.append((x, y))

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if maze[nx][ny] == 0:
                continue
            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1
                que.append((nx, ny))

    return maze[n-1][m-1]

n, m = map(int, input().split())
maze = [[0] * m for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(n):
    tmp = input().strip()
    for j in range(m):
        maze[i][j] = int(tmp[j])

print(search(0, 0))