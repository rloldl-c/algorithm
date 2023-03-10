import sys
input = sys.stdin.readline

def dfs(x, y):
    global win

    if x == n-1 and y == n-1:
        win = True
        return win

    visited[x][y] = True
    
    nx = x + game[x][y]
    ny = y + game[x][y]

    if 0 < nx < n and not visited[nx][y]:
        dfs(nx, y)
    
    if 0 < ny < n and not visited[x][ny]:
        dfs(x, ny)


n = int(input())
game = [[] for _ in range(n)]
visited = [[False] * n for _ in range(n)]
win = False

for i in range(n):
    game[i] = list(map(int, input().split()))

dfs(0, 0)

print("HaruHaru" if win else "Hing")