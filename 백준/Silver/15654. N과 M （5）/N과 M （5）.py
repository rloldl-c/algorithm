import sys
input = sys.stdin.readline

def recursion(cnt):
    if cnt == m:
        print(*tmp)
        return
    
    for i in range(n):
        if not visited[i]:
            visited[i] = True
            tmp.append(num[i])
            recursion(cnt+1)
            visited[i] = False
            tmp.pop()


n, m = map(int, input().split())
num = sorted(list(map(int, input().split())))
visited = [False] * n
tmp = []

recursion(0)