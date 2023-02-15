import sys
from collections import deque
input = sys.stdin.readline

left = deque(list(input().strip()))
right = deque()
n = int(input())

for _ in range(n):
    cmd = input().split()

    if cmd[0] == "L":
        if not left:
            continue
        else:
            tmp = left.pop()
            right.appendleft(tmp)
        
    elif cmd[0] == "D":
        if not right:
            continue
        else:
            tmp = right.popleft()
            left.append(tmp)

    elif cmd[0] == "B":
        if not left:
            continue
        else:
            left.pop()

    else:
        left.append(cmd[1])

print(*left, *right, sep="")