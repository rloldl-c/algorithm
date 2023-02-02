import sys
from collections import deque

input = sys.stdin.readline

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
que = deque([start])
res = [0] * (n+1)

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(len(graph)):
    graph[i] = sorted(graph[i])

cnt = 0

while que:
    i = que.popleft()

    visited[i] = True
    cnt += 1
    res[i] = cnt
    
    for j in graph[i]:
        if not visited[j]:
            visited[j] = True
            que.append(j)

print(*res[1:], sep="\n")