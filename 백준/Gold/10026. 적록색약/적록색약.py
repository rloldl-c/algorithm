import sys
input = sys.stdin.readline

def grb_dfs(x, y):
    cnt = 0

    stack = [(x, y)]

    if rgb_visited[x][y]:
        return cnt

    cnt += 1

    while stack:
        x, y = stack.pop()
        rgb_visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if rgb_visited[nx][ny]:
                continue

            if not rgb_visited[nx][ny] and grid[nx][ny] == grid[x][y]:
                rgb_visited[nx][ny] = True
                stack.append((nx, ny))

    return cnt

def rb_dfs(x, y):
    cnt = 0

    stack = [(x, y)]

    if rb_visited[x][y]:
        return cnt

    cnt += 1

    while stack:
        x, y = stack.pop()
        rb_visited[x][y] = True

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if rb_visited[nx][ny]:
                continue

            if not rb_visited[nx][ny]:
                if grid[nx][ny] in 'RG' and grid[x][y] in "RG" or grid[nx][ny] == 'B' and grid[x][y] == 'B':
                    rb_visited[nx][ny] = True
                    stack.append((nx, ny))

    return cnt



n = int(input())
grid = [0] * n
rgb_visited = [[False] * n for _ in range(n)]
rb_visited = [[False] * n for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
rgb_tmp = 0
rgb_res = 0
rb_tmp = 0
rb_res = 0

for i in range(n):
    grid[i] = list(input().strip())

for i in range(n):
    for j in range(n):
        if grid[i][j] in "RGB":
            rgb_tmp = grb_dfs(i, j)
            rgb_res += rgb_tmp
            rb_tmp = rb_dfs(i, j)
            rb_res += rb_tmp

print(rgb_res, rb_res)
