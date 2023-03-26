import sys
input = sys.stdin.readline

def quad(x, y, l):
    for i in range(x, x+l):
        for j in range(y, y+l):
            if video[i][j] != video[x][y]:
                res.append('(')
                quad(x, y, l//2)
                quad(x, y+l//2, l//2)
                quad(x+l//2, y, l//2)
                quad(x+l//2, y+l//2, l//2)
                res.append(')')
                return

    res.append(video[x][y])


n = int(input())
video = [input().strip() for _ in range(n)]
res = []
quad(0, 0, n)

print(*res, sep="")