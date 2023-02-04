import sys
input = sys.stdin.readline

def cut(x, y, l):
    for i in range(x, x+l):
        for j in range(y, y+l):
            if paper[i][j] != paper[x][y]:
                # l == 9일 때
                cut(x, y, l//3) # (0,0) ~ (2,2)
                cut(x+l//3, y, l//3) # (3,0) ~ (5,2)
                cut(x+l//3*2, y, l//3) # (6,0) ~ (8,2)
                cut(x, y+l//3, l//3) # (0,3) ~ (2,5)
                cut(x+l//3, y+l//3, l//3) # (3,3) ~ (5,5)
                cut(x+l//3*2, y+l//3, l//3) # (6,3) ~ (8,5)
                cut(x, y+l//3*2, l//3) # (0,6) ~ (2,8)
                cut(x+l//3, y+l//3*2, l//3) # (3,8) ~ (5,8)
                cut(x+l//3*2, y+l//3*2, l//3) # (6,8) ~ (8,8)
                return
  
    cnt.append(paper[x][y])

n = int(input())
paper = []
cnt = []

for _ in range(n):
    paper.append(list(map(int, input().split())))

cut(0, 0, n)

print(cnt.count(-1))
print(cnt.count(0))
print(cnt.count(1))