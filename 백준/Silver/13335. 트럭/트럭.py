import sys
from collections import deque
input = sys.stdin.readline

n, w, l = map(int, input().split())
truck = list(map(int, input().split()))
bridge = deque([0] * w)
idx = 0
cnt = 0

while True:
    bridge.popleft()

    if idx < n:
        tmp = truck[idx]

        if sum(bridge) + tmp <= l:
                bridge.append(tmp)
                idx += 1
        else:
            bridge.append(0)
    else:
         bridge.append(0)
    
    cnt += 1

    if sum(bridge) == 0:
        break

print(cnt)