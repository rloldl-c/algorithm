import sys
import heapq

input = sys.stdin.readline

visit = int(input())
santa = []

for _ in range(visit):
    n = list(map(int, input().split()))

    if n[0] == 0:
        if santa:
            a = heapq.heappop(santa)[1]
            print(a)
        else:
            print(-1)
    else:
        for i in range(1, len(n)):
            heapq.heappush(santa, (-n[i], n[i]))
