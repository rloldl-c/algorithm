import sys
import heapq

input = sys.stdin.readline

num = int(input())
numbers = []

for _ in range(num):
    n = int(input())

    if n != 0:
        heapq.heappush(numbers, n)
    else:
        if numbers:
            print(heapq.heappop(numbers))
        else:
            print(0)