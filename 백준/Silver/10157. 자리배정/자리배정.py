import sys
input = sys.stdin.readline

def pprint(arr):
    for i in range(len(arr)):
        print(arr[i])



c, r = map(int, input().split())
n = int(input())
check = [[0] * c for _ in range(r)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
cnt = 0
idx = 0
x = r
y = 0

if n > c*r:
    print(0)
else:
    while True:

        if cnt == n:
            print(y+1, r-x)
            break
    
        if x+dx[idx] < 0 or y+dy[idx] < 0 or x+dx[idx] >= r or y+dy[idx] >= c:
            idx = (idx+1) % 4

        if check[x+dx[idx]][y+dy[idx]] != 0:
            idx = (idx+1) % 4

        x += dx[idx]
        y += dy[idx]
        cnt += 1
        check[x][y] = cnt