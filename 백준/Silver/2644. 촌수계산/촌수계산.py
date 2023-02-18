import sys
input = sys.stdin.readline

def dfs(v, cnt):
    visited[v] = True

    if v == num2:
        ans.append(cnt)

    for i in graph[v]:
         if not visited[i]:
            dfs(i, cnt+1)
    return

n = int(input())
num1, num2 = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
ans = []

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v2].append(v1)
    graph[v1].append(v2)

dfs(num1, 0)

print(ans[0] if ans else -1)