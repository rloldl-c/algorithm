import sys
input = sys.stdin.readline

def pooling(x, y, size):
    if size == 2:
        tmp = [arr[x][y], arr[x+1][y], arr[x][y+1], arr[x+1][y+1]]
        tmp = sorted(tmp)
        return tmp[-2]

    cur_size = size//2

    area1 = pooling(x, y, cur_size)
    area2 = pooling(x+cur_size, y, cur_size)
    area3 = pooling(x, y+cur_size, cur_size)
    area4 = pooling(x+cur_size, y+cur_size, cur_size)

    tmp = [area1, area2, area3, area4]
    tmp = sorted(tmp)
    return tmp[-2]

n = int(input())
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

print(pooling(0, 0, n))
