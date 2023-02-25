import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())
arr = deque(i for i in range(2, n+1))
res = []

while True:
    min_ = arr.popleft()
    res.append(min_)
    tmp = deque()

    for i in arr:
        if i % min_ == 0:
            res.append(i)
        else:
            tmp.append(i)

    arr = tmp.copy()
    
    if not arr:
        break

print(res[k-1])