import sys
input = sys.stdin.readline


n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)
res = [0] * (n+1)

for _ in range(m):
    num = list(map(int, input().split()))
    graph[num[0]].append(num[1])
    graph[num[1]].append(num[0])

for i in range(len(graph)):
    graph[i] = sorted(graph[i], reverse=True)

stack = []
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