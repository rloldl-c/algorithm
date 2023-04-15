import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    que = deque()
    que.append(x, y)

    while que:
        x, y = que.popleft()
        board[x][y] = '.'

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < r and 0 <= ny < c:
                board[nx][ny] = '.'


r, c, n = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]
dxy = [(1, 0), (0, -1), (-1, 0), (0, 1)]
tmp = deque()
time = 2

for i in range(r):
    for j in range(c):
        if board[i][j] == 'O':
            board[i][j] = 3

while time < n+1:

    if time % 2 != 0:
        for i in range(r):
            for j in range(c):
                if board[i][j] == time:
                    tmp.append((i, j))

        while tmp:
            x, y = tmp.popleft()
            board[x][y] = '.'

            for dx, dy in dxy:
                nx = x + dx
                ny = y + dy

                if 0 <= nx < r and 0 <= ny < c:
                    board[nx][ny] = '.'
    else:
        for i in range(r):
            for j in range(c):
                if board[i][j] == '.':
                    board[i][j] = time + 3

    time += 1
    

for i in range(r):
    for j in range(c):
        if board[i][j] != '.':
            print('O', end='')
        else:
            print('.', end='')
    print()