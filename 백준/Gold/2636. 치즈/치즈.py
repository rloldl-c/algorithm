import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    que = deque()
    que.append((0, 0))
    visited[0][0] = True
    cnt = 0

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < r and 0 <= ny < c and not visited[nx][ny]:
                visited[nx][ny] = True
                if graph[nx][ny] == 0:
                    que.append((nx, ny))
                elif graph[nx][ny] == 1:
                    graph[nx][ny] = 0
                    cnt += 1

    return cnt


r, c = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(r)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
ans = []
time = 0

while True:
    visited = [[False] * c for _ in range(r)]
    cnt = bfs()

    if cnt == 0:
        break

    time += 1
    ans.append(cnt)

print(time)
print(ans[-1])