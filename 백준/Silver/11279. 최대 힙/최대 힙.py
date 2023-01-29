import sys
import heapq
input = sys.stdin.readline

num = int(input())
arr =[]

for _ in range(num):
    n = int(input())

    if n == 0:
        if arr:
            print(heapq.heappop(arr)[1])
        else:
            print(0)
    else:
        heapq.heappush(arr, (-n, n))