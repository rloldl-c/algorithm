import sys
input = sys.stdin.readline

def check(x, y, l):
    for i in range(x, x+l):
        for j in range(y, y+l):
            if paper[i][j] != paper[x][y]:
                check(x, y, l//2)
                check(x+l//2, y, l//2)
                check(x, y+l//2, l//2)
                check(x+l//2, y+l//2, l//2)
                return

    ans.append(paper[x][y])


n = int(input())
paper = [[] for _ in range(n)]
ans = []

for i in range(n):
    paper[i] = list(map(int, input().split()))

check(0, 0, n)

print(ans.count(0), ans.count(1), sep="\n")