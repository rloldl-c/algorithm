import sys
input = sys.stdin.readline

def recursion(cnt):
    if cnt == m:
        print(*tmp)
        return

    else:
        for i in range(1, n+1):
            if i not in tmp:
                tmp.append(i)
                recursion(cnt+1)
                tmp.pop()


n, m = map(int, input().split())
tmp = []
recursion(0)