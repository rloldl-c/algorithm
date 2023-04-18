import sys
from collections import deque
import copy
input = sys.stdin.readline

def bfs(x, y, d):
    max_d = 0
    que = deque([(x, y, d)])
    visited[x][y] = True

    while que:
        x, y, d = que.popleft()

        if max_d < d:
            max_d = d

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                if graph[nx][ny] == 'L':
                    visited[nx][ny] = True
                    que.append((nx, ny, d+1))

    return max_d

r, c = map(int, input().split())
graph = [list(input().strip()) for _ in range(r)]
dxy = [(1, 0), (-1, 0), (0, 1), (0, -1)]
ans = 0

for i in range(r):
    for j in range(c):
        if graph[i][j] == 'L':
            visited = [[False for _ in range(c)] for _ in range(r)]
            ans = max(ans, bfs(i, j, 0))

print(ans)