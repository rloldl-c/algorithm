import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    que = deque()
    que.append((x, y))

    while que:
        x, y = que.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= r or ny < 0 or ny >= c:
                continue
            if field[nx][ny] == 0:
                continue
            if field[nx][ny] == 1:
                field[nx][ny] = 0
                que.append((nx, ny))

    return


test = int(input())

for _ in range(test):
    r, c, n = map(int, input().split())
    field = [[0] * c for _ in range(r)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    cnt = 0

    for _ in range(n):
        x, y = map(int, input().split())
        field[x][y] = 1

    for i in range(r):
        for j in range(c):
            if field[i][j] == 1:
                cnt += 1
                bfs(i, j)

    print(cnt)
