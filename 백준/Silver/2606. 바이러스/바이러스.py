import sys
from collections import deque

input = sys.stdin.readline

n = int(input()) # 정점 개수
m = int(input()) # 간선 개수
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

start = 1
cnt = 0

stack = [start]

while stack:
    i = stack.pop()
    visited[i] = True
    cnt += 1

    for j in graph[i]:
        if not visited[j]:
            visited[j] = True
            stack.append(j)

print(cnt-1)