import sys
input = sys.stdin.readline

def dfs(x, y):
    cnt = 0
    stack = [(x, y)]

    while stack:
        x, y = stack.pop()
        visited[x][y] = True
        cnt += 1

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx >= n or ny < 0 or ny >= n or visited[nx][ny]:
                continue

            if graph[nx][ny] <= k:
                continue

            if graph[nx][ny] > k:
                visited[nx][ny] = True
                stack.append((nx, ny))

    return cnt



n = int(input())
graph = []
dxy = [(-1, 0), (0, -1), (1, 0), (0, 1)]

for _ in range(n):
    graph.append(list(map(int, input().split())))

rain = max(map(max, graph))
max_zone = 1

for k in range(rain-1, -1, -1):
    visited = [[False] * n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if graph[i][j] > k and not visited[i][j]:
                cnt += 1
                dfs(i, j)

    max_zone = max(max_zone, cnt)

print(max_zone)