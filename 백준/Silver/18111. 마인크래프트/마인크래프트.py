import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
ground = {}

for _ in range(n):
    for n in list(map(int, input().split())):
        if n not in ground:
            ground[n] = 1
        else:
            ground[n] += 1

max_h = max(ground.keys())
min_h = min(ground.keys())
res_t = int(1e9)
res_h = 0

for target in range(min_h, max_h+1):
    remove = 0
    build = 0
    item = b

    for h in ground:
        if target > h:
            build += ground[h] * (target - h)
            item -= ground[h] * (target - h)
        elif target < h:
            remove += ground[h] * (h - target)
            item += ground[h] * (h - target)

    if item < 0:
        break

    if res_t >= remove * 2 + build:
        res_t = remove * 2 + build
        res_h = target

print(res_t, res_h)

