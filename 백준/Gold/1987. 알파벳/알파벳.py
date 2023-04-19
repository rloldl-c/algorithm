import sys
input = sys.stdin.readline

def bfs(x, y, before):
    global ans
    que = set([(x, y, before)])
    
    while que:
        x, y, before = que.pop()

        ans = max(ans, len(before))

        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < r and 0 <= ny < c and board[nx][ny] not in before:
                que.add((nx, ny, before+board[nx][ny]))


r, c = map(int, input().split())
board = [list(input().strip()) for _ in range(r)]
dxy = [(1, 0), (0, -1), (0, 1), (-1, 0)]
ans = 0
bfs(0, 0, board[0][0])
print(ans)