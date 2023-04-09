import sys
from collections import deque
input = sys.stdin.readline

def bfs(x):
    visited = [0] * (n+1)
    que = deque()
    que.append(x)

    while que:
        now = que.popleft()

        for i in member[now]:
            if visited[i] == 0 and i != x:
                visited[i] = visited[now] + 1
                que.append(i)
    
    score[x] = max(visited)
    return

n = int(input())
member = [0] + [[] for _ in range(n)]
score = [int(1e9)] + [int(1e9) for _ in range(n)]

while True:
    a, b = map(int, input().split())

    if a == b == -1:
        break

    member[a].append(b)
    member[b].append(a)

for i in range(1, n+1):
    bfs(i)

min_ = min(score)
print(min_, score.count(min_))
for i in range(1, n+1):
    if score[i] == min_:
        print(i, end=" ")