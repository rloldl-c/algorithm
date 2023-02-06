import sys
input = sys.stdin.readline


def dfs(x, y):
    stack = [(x, y)]

    while stack:
        x, y = stack.pop()
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = 0
                stack.append((nx, ny))

    return

while True:
    dx = [-1, -1, 0, 1, 1, 1, 0, -1]
    dy = [0, -1, -1, -1, 0, 1, 1, 1]
    m, n = map(int, input().split())
    cnt = 0

    if n + m == 0:
        break

    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().split())))

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                cnt += 1
                dfs(i, j)

    print(cnt)