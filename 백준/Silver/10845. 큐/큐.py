import sys
from collections import deque

input = sys.stdin.readline

num = int(input())
que = deque()

for i in range(num):
    cmd = input().split()

    if cmd[0] == "push":
        que.append(cmd[1])
    elif cmd[0] == "pop":
        if len(que) == 0:
            print(-1)
        else:
            a = que.popleft()
            print(a)
    elif cmd[0] == "size":
        print(len(que))
    elif cmd[0] == "empty":
        if len(que) == 0:
            print(1)
        else:
            print(0)
    elif cmd[0] == "front":
        if len(que) == 0:
            print(-1)
        else:
            clone = que.copy()
            a = clone.popleft()
            print(a)
    else:
        if len(que) == 0:
            print(-1)
        else:
            clone = que.copy()
            a = clone.pop()
            print(a)
