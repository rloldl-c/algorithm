import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    que.append((x, y))

    while que:
        x, y = que.popleft()
        visited[x][y] = True

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if visited[nx][ny]:
                continue

            visited[nx][ny] = True
            arr[nx][ny] = arr[x][y] + 1    
            que.append((nx, ny))
    return

test = int(input())
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]

for _ in range(test):
    n = int(input())
    arr = [[0] * n for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    
    x, y = map(int, input().split())
    to_x, to_y = map(int, input().split())
    
    que = deque()
    
    bfs(x, y)

    print(arr[to_x][to_y])