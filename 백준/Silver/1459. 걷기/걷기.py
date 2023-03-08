import sys
input = sys.stdin.readline

x, y, straight, opposite = map(int, input().split())
ans = 0

if x != 0 and y != 0:
    if straight * 2 > opposite:
        if x > y:
            ans += opposite * y
            x -= y
            y = 0
            
        else:
            ans += opposite * x
            tmp = y-x
            y -= x
            x = 0

if straight > opposite:
    tmp = x // 2
    ans += opposite * tmp * 2
    x -= tmp * 2
    tmp = y // 2
    ans += opposite * tmp * 2
    y -= tmp * 2

ans += straight * (x+y)

print(ans)