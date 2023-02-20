import sys
input = sys.stdin.readline

def bfs(x, y, cnt, apple):
    tmp = board[x][y]
    board[x][y] = -1
    global res

    if apple >= 2 and cnt <= 3:
        res = True
        return res

    for dx, dy in dxy:
        nx = x + dx
        ny = y + dy

        if nx < 0 or nx >= 5 or ny < 0 or ny >= 5:
            continue

        if board[nx][ny] == -1:
            continue

        if board[nx][ny] == 1:
            bfs(nx, ny, cnt+1, apple+1)
        elif board[nx][ny] == 0:
            bfs(nx, ny, cnt+1, apple)

    board[x][y] = tmp



board = [[] for _ in range(5)]
dxy = [(-1, 0), (0, -1), (1, 0), (0, 1)]
res = False

for i in range(5):
    board[i] = list(map(int, input().split()))

x, y = map(int, input().split())

bfs(x, y, 0, 0)

print(1 if res else 0)