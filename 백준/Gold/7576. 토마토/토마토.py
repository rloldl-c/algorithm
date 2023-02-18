import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    while que:
        x, y = que.popleft()

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if tomato[nx][ny] == 0:
                tomato[nx][ny] = tomato[x][y] + 1
                que.append((nx, ny))
            elif tomato[nx][ny] > tomato[x][y] + 1:
                tomato[nx][ny] = tomato[x][y] + 1
                que.append((nx, ny))

    return


m, n = map(int, input().split())
tomato = []
dxy = [(-1, 0), (0, -1), (1, 0), (0, 1)]
que = deque()

for _ in range(n):
    tomato.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            que.append((i, j))

bfs()
is_zero = False

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 0:
            is_zero = True
            break
    if is_zero:
        break

if is_zero:
    print(-1)
else:
    print(max(map(max, tomato))-1)