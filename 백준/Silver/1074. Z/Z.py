import sys
input = sys.stdin.readline

def visit(x, y, size):
    global cnt

    if x > r or x + size <= r or y > c or y + size <= c:
        cnt += size**2
        return

    if size == 2:
        if r == x and c == y:
            print(cnt)
        elif r == x and c == y+1:
            print(cnt+1)
        elif r == x+1 and c == y:
            print(cnt+2)
        else:
            print(cnt+3)
        return
    
    cur_size = size//2
    visit(x, y, cur_size)
    visit(x, y+cur_size, cur_size)
    visit(x+cur_size, y, cur_size)
    visit(x+cur_size, y+cur_size, cur_size)

n, r, c = map(int, input().split())
cnt = 0

visit(0, 0, 2**n)

