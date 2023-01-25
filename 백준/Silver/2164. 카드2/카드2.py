import sys
from collections import deque

input = sys.stdin.readline

num = int(input())
card = deque()

for i in range(1, num+1):
    card.append(i)

while len(card) != 1:
    card.popleft()
    tmp = card.popleft()
    card.append(tmp)

ans = card.pop()
print(ans)