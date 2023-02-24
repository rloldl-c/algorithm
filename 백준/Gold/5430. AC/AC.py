import sys
from collections import deque
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    isError = False
    cmd = list(input().strip())
    n = int(input())
    tmp = input().strip().replace('[', '').replace(']', '')
    deq = deque(tmp.split(','))
    rev = 1
    
    for i in cmd:
        if i == 'R':
            rev *= (-1)
        else:
            if deq and n > 0:
                if rev == 1:
                    deq.popleft()
                elif rev == -1:
                    deq.pop()
            else:
                isError = True
                break

    if isError:
        print('error')
    else:
        if rev == -1:
            deq.reverse()
        
        print('[', end="")
        print(*deq, sep=",", end="")
        print(']')
