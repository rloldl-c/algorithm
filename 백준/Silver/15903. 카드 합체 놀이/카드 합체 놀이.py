import sys
import heapq

input = sys.stdin.readline

num, combi = map(int, input().split())
cards = []
numbers = map(int, input().split())
tmp = []

for n in numbers:
    heapq.heappush(cards, n)

for _ in range(combi):
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)

    heapq.heappush(cards, a + b)
    heapq.heappush(cards, a + b)

        
print(sum(cards))
