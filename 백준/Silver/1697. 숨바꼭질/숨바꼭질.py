import sys
from collections import deque
input = sys.stdin.readline


def bfs(x):
    que = deque()
    que.append(x)

    while que:
        nx = que.popleft()

        if nx == k:
            return

        if 0 <= nx-1 < 100001 and arr[nx-1] == 0:
            arr[nx-1] = arr[nx] + 1
            que.append(nx-1)

        if 0 <= nx+1 < 100001 and arr[nx+1] == 0:
            arr[nx+1] = arr[nx] + 1
            que.append(nx+1)

        if 0 <= nx*2 < 100001 and arr[nx*2] == 0:
            arr[nx*2] = arr[nx] + 1
            que.append(nx*2)


arr = [0] * 100001
n, k = map(int, input().split())

bfs(n)

print(arr[k])