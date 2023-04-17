import sys
from collections import deque
input = sys.stdin.readline

# 우 상 좌 하
dxy = [(0, 1), (-1, 0), (0, -1), (1, 0)]
idx = 0
snake = deque([(0, 0)])
time = 0

n = int(input())
board = [[0 for _ in range(n)] for _ in range(n)]
k = int(input())

for _ in range(k):
    i, j = map(int, input().split())
    board[i-1][j-1] = 1

l = int(input())
oper = [0] * 10001

for _ in range(l):
    # L 왼쪽 D 오른쪽
    t, d = input().split()
    oper[int(t)] = d

while True:
    dx, dy = snake.pop()
    snake.append((dx, dy))
    nx = dx + dxy[idx][0]
    ny = dy + dxy[idx][1]

    time += 1

    if 0 > nx or nx >= n or 0 > ny or ny >= n:
        break

    if (nx, ny) in snake:
        break
    
    snake.append((nx, ny))

    if board[nx][ny] == 0:
        snake.popleft()
    else:
        board[nx][ny] = 0

    if oper[time] == 'D':
        idx = (idx - 1) % 4
    elif oper[time] == 'L':
        idx = (idx + 1) % 4

print(time)