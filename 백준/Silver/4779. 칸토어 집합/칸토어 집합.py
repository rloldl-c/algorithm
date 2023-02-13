import sys
input = sys.stdin.readline

def cut(start, length):
    now = length // 3

    if now == 0:
        return

    for i in range(start + now, start + now*2):
        res[i] = " "

    cut(start, now)
    cut(start + now * 2, now)
            
while True:
    try:
        n = input()
        if n == "":
            break
        else:
            n = int(n)
            res = ["-" for _ in range(3**n)]

            cut(0, 3**n)

            print(*res, sep="")
    except EOFError:
        break