import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    que = deque()
    que.append((x, y))
    visited[x][y] = True
    tmp = 1

    while que:
        x, y = que.popleft()

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny]:
                continue
            if graph[nx][ny] == 0:
                visited[nx][ny] = True
                que.append((nx, ny))
                tmp += 1

    return tmp


n, m, k = map(int, input().split())
graph = [[0] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
dxy = [(-1, 0), (0, -1), (1, 0), (0, 1)]
cnt = 0
res = []

for _ in range(k):
    start_y, start_x, end_y, end_x = map(int, input().split())

    for i in range(start_x, end_x):
        for j in range(start_y, end_y):
            graph[i][j] = 1

for i in range(n):
    for j in range(m):
        if graph[i][j] == 0 and not visited[i][j]:
            cnt += 1
            res.append(bfs(i, j))

res = sorted(res)

print(cnt)

for n in res:
    if n != 0:
        print(n, end=" ")