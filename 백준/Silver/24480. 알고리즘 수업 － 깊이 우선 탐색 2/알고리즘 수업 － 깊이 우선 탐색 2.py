import sys
input = sys.stdin.readline

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
stack = []
res = [0] * (n+1)

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(len(graph)):
    graph[i] = sorted(graph[i])

stack.append(start)
visited[start] = True
cnt = 1
res[start] = cnt

while stack:
    i = stack.pop()
    if not visited[i]:
        visited[i] = True
        cnt += 1
        res[i] = cnt

    for j in graph[i]:
        if not visited[j]:
            stack.append(j)

print(*res[1:], sep="\n")