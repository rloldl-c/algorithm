import sys
from collections import deque
input = sys.stdin.readline

test = int(input())

for t in range(test):
    stu = deque(map(int, input().split()))
    sorted_stu = []
    cnt = 0
    
    stu.popleft()
    m = stu.popleft()
    sorted_stu.append(m)

    while stu:
        tmp = stu.popleft()

        if m > tmp:
            for i in range(len(sorted_stu)):
                if sorted_stu[i] > tmp:
                    cnt += len(sorted_stu) - i
                    sorted_stu.append(tmp)
                    sorted_stu = sorted(sorted_stu)
                    break
        else:
            sorted_stu.append(tmp)
            m = tmp

    print(t+1, cnt)