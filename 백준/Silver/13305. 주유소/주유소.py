import sys
input = sys.stdin.readline

n = int(input())
road = list(map(int, input().split()))
cost = list(map(int, input().split()))
total = road[0] * cost[0]
min_cost = cost[0]

for i in range(1, len(road)):
    if cost[i] < min_cost:
        min_cost = cost[i]

    total += min_cost * road[i]

print(total)