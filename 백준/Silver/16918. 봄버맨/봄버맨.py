import sys
input = sys.stdin.readline

r, c, n = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]
dxy = [(1, 0), (0, -1), (-1, 0), (0, 1)]
ans = [['O' for _ in range(c)] for _ in range(r)]

if n == 1:
    ans = board
elif n % 2 == 0:
    ans = [['O' for _ in range(c)] for _ in range(r)]
elif n % 4 == 1:
    tmp = [['O' for _ in range(c)] for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if board[i][j] == 'O':
                ans[i][j] = '.'
                for dx, dy in dxy:
                    if 0 <= i+dx < r and 0 <= j+dy < c:
                        ans[i+dx][j+dy] = '.'

    for i in range(r):
        for j in range(c):
            if ans[i][j] == 'O':
                tmp[i][j] = '.'
                for dx, dy in dxy:
                    if 0 <= i+dx < r and 0 <= j+dy < c:
                        tmp[i+dx][j+dy] = '.'

    ans = tmp
    
else:
    for i in range(r):
        for j in range(c):
            if board[i][j] == 'O':
                ans[i][j] = '.'
                for dx, dy in dxy:
                    if 0 <= i+dx < r and 0 <= j+dy < c:
                        ans[i+dx][j+dy] = '.'


for i in range(r):
    print(''.join(ans[i]))