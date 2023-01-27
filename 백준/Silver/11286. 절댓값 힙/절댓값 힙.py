import sys
import heapq

input = sys.stdin.readline

test = int(input())
numbers = []

for _ in range(test):
    n = int(input())

    if n != 0:
        heapq.heappush(numbers, (abs(n), n))
    else:
        if numbers:
            print(heapq.heappop(numbers)[1])
        else:
            print(0)

