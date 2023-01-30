import sys
from collections import deque
input = sys.stdin.readline

size = int(input())

router = deque()

while True:
    n = int(input())

    if n == -1:
        break
    elif n == 0:
        router.popleft()
    else:
        if len(router) >= size:
            while len(router) > size:
                router.pop()
        else:
            router.append(n)

if router:
    print(*router)
else:
    print("empty")