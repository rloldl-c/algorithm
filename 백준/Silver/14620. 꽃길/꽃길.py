import sys
input = sys.stdin.readline

def check(x, y):
    if visited[x][y]:
        return False
    
    for dx, dy in flower:
        if visited[x+dx][y+dy]:
            return False
        
    return True


def visit(x, y, flag):
    tmp = garden[x][y]
    visited[x][y] = flag

    for dx, dy in flower:
        visited[x+dx][y+dy] = flag
        tmp += garden[x+dx][y+dy]
    
    return tmp



def blooming(x, y, cnt, cost):
    global ans

    if cnt == 3:
        ans = min(ans, cost)
        return
    
    for nx in range(x, n-1):
        for ny in range(y, n-1):
            if not check(nx, ny):
                continue

            tmp = visit(nx, ny, True)
            blooming(nx, ny, cnt+1, cost+tmp)
            visit(nx, ny, False)
    
        y = 1


n = int(input())
garden = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * n for _ in range(n)]
flower = [(-1, 0), (0, -1), (1, 0), (0, 1)]
ans = 3000

blooming(1, 1, 0, 0)
print(ans)