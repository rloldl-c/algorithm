import sys
import heapq
input = sys.stdin.readline

num = int(input())
arr = []

for _ in range(num):
    numbers = list(map(int, input().split()))
    for number in numbers:
        heapq.heappush(arr, number)
        if len(arr) > num:
            heapq.heappop(arr)

print(heapq.heappop(arr))