import sys
from collections import deque

n, m = map(int, input().split())
target = list(map(int, input().split()))
numbers = deque(i for i in range(1, n+1))
cnt = 0

for i in range(m):
    tmp = numbers.popleft()

    if target[i] == tmp:
        continue
    else:
        while target[i] != tmp:
            idx = numbers.index(target[i]) + 1
            if idx > len(numbers)//2:
                numbers.appendleft(tmp)
                numbers.appendleft(numbers.pop())
                tmp = numbers.popleft()
                cnt += 1
            else:
                numbers.appendleft(tmp)
                numbers.append(numbers.popleft())
                tmp = numbers.popleft()
                cnt += 1

print(cnt)