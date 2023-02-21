import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    visited = [-1 for _ in range(n+1)]
    que = deque()
    que.append(start)
    visited[start] = 0

    while que:
        now = que.popleft()

        for nd in graph[now]:
            if visited[nd] != -1:
                continue

            visited[nd] = visited[now] + 1
            que.append(nd)

    visited[0] = 0
    return sum(visited)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
ans = [0] * (n+1)

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

min_ = int(1e9)
min_idx = 0

for i in range(1, n+1):
    tmp = bfs(i)
    if tmp < min_:
        min_ = tmp
        min_idx = i

print(min_idx)
