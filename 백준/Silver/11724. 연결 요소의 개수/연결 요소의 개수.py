import sys
input = sys.stdin.readline

n, m = map(int, input().split()) # 정점 개수, 간선 개수
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
cnt = 0

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(1, n+1):
    if not visited[i]:
        stack = [i]
        cnt += 1

        while stack:
            now = stack.pop()
            visited[now] = True

            for j in graph[now]:
                if not visited[j]:
                    visited[j] = True
                    stack.append(j)

print(cnt)