import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    visited[1] = 1
    que.append(1)

    while que:
        x = que.popleft()

        for i in range(1, len(graph[x])):
            nx = graph[x][i]
            if not visited[nx]:
                visited[nx] = visited[x] + 1
                que.append(nx)


n, m = map(int, input().split())
graph = [[0]] + [[0] for _ in range(n)]
visited = [0 for _ in range(n+1)]
que = deque()
ans_num = 0
ans_cnt = 0
ans_dis = 0

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


bfs()

for i in range(n+1):
    if visited[i] > ans_dis:
        ans_dis = visited[i]
        ans_num = i
        ans_cnt = 1

    elif visited[i] == ans_dis:
        ans_cnt += 1

print(ans_num, ans_dis-1, ans_cnt)