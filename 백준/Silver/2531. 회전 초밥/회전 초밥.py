import sys
from collections import deque
input = sys.stdin.readline

n, d, k, c = map(int, input().split())
sushi = deque([int(input()) for _ in range(n)])
ans = 0
s = 0
e = 0
check = deque()

while s != n:

    check.append(sushi[e%n])
    
    if e - s >= k-1:
        if c not in check:
            ans = max(ans, len(set(check))+1)
        else:
            ans = max(ans, len(set(check)))

    if s == e or e - s < k:
        e += 1
    
    if e - s > k-1:
        s += 1
        check.popleft()

print(ans)