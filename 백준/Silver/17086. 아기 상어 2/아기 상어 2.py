import sys
from collections import deque
input = sys.stdin.readline


def bfs(x, y):
    que = deque()
    que.append((x, y))
    
    while que:
        x, y = que.popleft()

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                que.append((nx, ny))
            elif graph[nx][ny] > graph[x][y] + 1:
                graph[nx][ny] = graph[x][y] + 1
                que.append((nx, ny))

    return

n, m = map(int, input().split())
graph = []
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]
cnt = 0

for _ in range(n):
    graph.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            bfs(i, j)

print(max(map(max, graph))-1)