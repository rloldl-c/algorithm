import sys
from collections import deque
input = sys.stdin.readline

def bfs(i, j):
    cnt = 1
    que = deque()
    que.append((i, j))
    
    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dxy[i][0]
            ny = y + dxy[i][1]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                que.append((nx, ny))
                cnt += 1

    # print(cnt)
    return cnt


n, m, k = map(int, input().split())
graph = [[0] * (m) for _ in range(n)]
dxy = [(-1, 0), (0, -1), (1, 0), (0, 1)]
# visited = [[False] * (m+1) for _ in range(n+1)]
ans = 0

for _ in range(k):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1

for i in range(n):
    for j in range(m):
        if graph[i][j] != 0:
            graph[i][j] = 0
            ans = max(ans, bfs(i, j))

print(ans)