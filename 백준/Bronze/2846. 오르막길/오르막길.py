import sys

num = int(sys.stdin.readline().strip())
roads = list(map(int, sys.stdin.readline().split()))
max_h = 0
res = 0

for i in range(num):
    for j in range(i+1, num):
        if roads[i] >= roads[j]:
            break
        elif roads[j] <= roads[j-1]:
            break
        else:
            # print(roads[i], roads[j])
            max_h = roads[j] - roads[i]
            res = max(res, max_h)

print(res)