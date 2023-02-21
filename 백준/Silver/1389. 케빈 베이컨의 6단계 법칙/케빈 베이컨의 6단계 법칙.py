import sys
input = sys.stdin.readline

n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            graph[i][j] = 0

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

min_ = 0
res = INF
res_idx = 0

for i in range(1, n+1):
    min_ = 0
    for j in range(1, n+1):
        min_ += graph[i][j]

    if min_ < res:
        res = min_
        res_idx = i

print(res_idx)