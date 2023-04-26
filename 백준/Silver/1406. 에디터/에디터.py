import sys
from collections import deque

input = sys.stdin.readline

n = input().strip()
m = int(input())
left = deque(list(n))
right = deque([])

for _ in range(m):
    cmd = list(input().split())
    
    if cmd[0] == 'L':
        if not left:
            continue
        else:
            tmp = left.pop()
            right.appendleft(tmp)

    elif cmd[0] == 'D':
        if not right:
            continue
        else:
            tmp = right.popleft()
            left.append(tmp)

    elif cmd[0] == 'B':
        if not left:
            continue
        else:
            left.pop()

    else:
        left.append(cmd[1])


print(''.join(left) + ''.join(right))