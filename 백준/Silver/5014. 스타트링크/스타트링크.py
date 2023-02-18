import sys
from collections import deque
input = sys.stdin.readline


F, S, G, U, D = map(int, input().split())
arr = [0] * (F+1)

que = deque()
que.append(S)

while que:
    x = que.popleft()

    if x == G:
        print(arr[G])
        break

    for nx in [x+U, x-D]:
        if nx == x:
            continue
        if 0 < nx <= F and arr[nx] == 0:
            arr[nx] = arr[x] + 1
            que.append(nx)
else:
    print("use the stairs")
