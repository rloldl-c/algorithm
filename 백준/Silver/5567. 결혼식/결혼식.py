import sys
from collections import deque
input = sys.stdin.readline

def dfs(idx, cnt):
    global ans

    if visited[idx] or cnt > 2:
        return
    
    if idx != 1:
        ans += 1

    visited[idx] = True
    for i in graph[idx]:
        if not visited[i]:
            if graph[i][0] == 1:
                dfs(i, 1)
            else:
                dfs(i, cnt+1)


n = int(input())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
ans = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(n):
    graph[i] = sorted(graph[i])


dfs(1, 0)

print(ans)

