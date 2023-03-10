import sys
input = sys.stdin.readline

def check(cnt):
    if cnt == n:
        return print(*ans)

    for i in range(1, n+1):
        if not visited[i]:
            visited[i] = True
            ans.append(i)
            check(cnt+1)
            ans.pop()
            visited[i] = False


n = int(input())
visited = [False] * (n+1)
ans = []
check(0)