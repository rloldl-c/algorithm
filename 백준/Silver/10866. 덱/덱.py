import sys
from collections import deque

input = sys.stdin.readline

deq = deque()

num = int(input())

for i in range(num):
    cmd = input().split()

    if cmd[0] == "push_front":
        deq.appendleft(cmd[1])
    elif cmd[0] == "push_back":
        deq.append(cmd[1])
    elif cmd[0] == "pop_front":
        if len(deq) == 0:
            print(-1)
        else:
            a = deq.popleft()
            print(a)
    elif cmd[0] == "pop_back":
        if len(deq) == 0:
            print(-1)
        else:
            a = deq.pop()
            print(a)
    elif cmd[0] == "size":
        print(len(deq))
    elif cmd[0] == "empty":
        print(1 if len(deq) == 0 else 0)
    elif cmd[0] == "front":
        if len(deq) == 0:
            print(-1)
        else:
            a = deq.copy().popleft()
            print(a)
    else:
        if len(deq) == 0:
            print(-1)
        else:
            a = deq.copy().pop()
            print(a)
    