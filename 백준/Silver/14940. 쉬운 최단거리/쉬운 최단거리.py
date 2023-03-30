import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    que = deque()

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                que.append((i, j))
                graph[i][j] = 0

                while que:
                    x, y = que.popleft()
                    visited[x][y] = True

                    for i in range(4):
                        nx = x + dxy[i][0]
                        ny = y + dxy[i][1]

                        if nx < 0 or nx >= n or ny < 0 or ny >= m:
                            continue
                        if not visited[nx][ny] and graph[nx][ny] == 1:
                            visited[nx][ny] = True
                            graph[nx][ny] = graph[x][y] + 1
                            que.append((nx, ny))

                return


n, m = map(int, input().split())
graph = []
ans = [[-1] * m for _ in range(n)]
dxy = [(1, 0), (0, 1), (-1, 0), (0, -1)]
visited = [[False] * m for _ in range(n)]

for i in range(n):
    graph.append(list(map(int, input().split())))

bfs()

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and not visited[i][j]:
            print(-1, end=' ')
        else:
            print(graph[i][j], end=' ')
    print()