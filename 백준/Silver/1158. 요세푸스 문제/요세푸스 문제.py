import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
que = deque([i for i in range(1, n+1)])
res = []
cnt = 1

while que:
    if cnt == k:
        tmp = que.popleft()
        res.append(tmp)
        cnt = 0
    else:
        tmp = que.popleft()
        que.append(tmp)

    cnt += 1

print("<", end="")
print(*res, sep=", ", end="") 
print(">")   