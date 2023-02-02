import sys
from collections import deque
input = sys.stdin.readline

def dfs(graph, n, visited):
    visited[n] = True
    print(n, end=" ")
    
    for i in graph[n]:
        if not visited[i]:
            dfs(graph, i, visited)

def bfs(graph, n, visited):
    que = deque([n])
    visited[n] = True

    while que:
        i = que.popleft()
        print(i, end=" ")

        for j in graph[i]:
            if not visited[j]:
                que.append(j)
                visited[j] = True

n, m, start = map(int, input().split())
graph = [[] for _ in range(n+1)]
dfs_visited = [False] * (n+1)
bfs_visited = [False] * (n+1)

for _ in range(1, m+1):
    numbers = list(map(int, input().split()))
    graph[numbers[0]].append(numbers[1])
    graph[numbers[1]].append(numbers[0])
    graph[numbers[0]].sort()
    graph[numbers[1]].sort()

dfs(graph, start, dfs_visited)
print()
bfs(graph, start, bfs_visited)