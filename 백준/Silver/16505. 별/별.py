import sys
input = sys.stdin.readline

def star(x, y, l):
    arr[x][y] = "*"

    if l == 0:
        return

    star(x, y, l-1)
    star(x+2**(l-1), y, l-1)
    star(x, y+2**(l-1), l-1)
    

n = int(input())
arr = [[" "] * (2**n) for _ in range(2**n)]
star(0, 0, n)

for i in range(len(arr)):
    print("".join(arr[i]).rstrip())