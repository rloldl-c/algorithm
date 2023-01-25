import sys
from collections import deque

input = sys.stdin.readline

que = deque()
num = int(input())

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
        print(1 if len(que) == 0 else 0)
    elif cmd[0] == "front":
        if len(que) == 0:
            print(-1)
        else:
            a = que.popleft()
            print(a)
            que.appendleft(a)
    else:
        if len(que) == 0:
            print(-1)
        else:
            a = que.pop()
            print(a)
            que.append(a)