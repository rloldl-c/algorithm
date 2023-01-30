import sys
import heapq

input = sys.stdin.readline

n = int(input())
vote = [int(input()) for _ in range(n)]
ds = vote[0]
cnt = 0

if n == 1:
    print(0)
else:
    heap = []
    for num in vote:
        if num >= ds:
            heapq.heappush(heap, [-num, num])

    while heap:
        a = heapq.heappop(heap)

        if not heap:
            break
        elif a[1] < ds:
                break
        else:
            a[1] -= 1
            a[0] = -a[1]
            heapq.heappush(heap, a)
            ds += 1
            cnt += 1

    print(cnt)