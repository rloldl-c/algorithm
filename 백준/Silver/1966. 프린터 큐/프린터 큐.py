import sys
from collections import deque

input = sys.stdin.readline

test = int(input())

for i in range(test):
    que = deque()
    num, idx = map(int, input().split())
    numbers = list(map(int, input().split()))
    
    for number in numbers:
        que.append(number)

    cnt = 0

    if num == 1:
        print(1)
    else:
        while True:
            top = max(que)
            tmp = que.popleft()
            idx -= 1

            if top == tmp:
                cnt += 1
                if idx < 0:
                    print(cnt)
                    break
            else:
                que.append(tmp)
                if idx < 0:
                    idx = len(que) - 1