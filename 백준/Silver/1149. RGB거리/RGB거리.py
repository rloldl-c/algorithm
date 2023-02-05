import sys
input = sys.stdin.readline

n = int(input())
house = []
cost = [[0, 0, 0] for _ in range(n)]

for _ in range(n):
    house.append(list(map(int, input().split())))

# 첫 번째 집은 첫 번째 비용으로 초기화
cost[0][0] = house[0][0]
cost[0][1] = house[0][1]
cost[0][2] = house[0][2]

# 이전 집과 겹치지 않는 색상 중에서 이전 집까지 더한 비용과 현재 색상 비용을 더해서 최소값을 할당
for i in range(1, n):
    cost[i][0] = min(house[i][0] + cost[i-1][2], house[i][0] + cost[i-1][1])
    cost[i][1] = min(house[i][1] + cost[i-1][2], house[i][1] + cost[i-1][0])
    cost[i][2] = min(house[i][2] + cost[i-1][0], house[i][2] + cost[i-1][1])

print(min(cost[n-1]))