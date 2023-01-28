import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trees = list(map(int, input().split()))

trees.sort()

max_len = 0
s = 1
e = trees[-1]

while s <= e:
    mid = (s + e) // 2
    home = 0

    for tree in trees:
        if tree > mid:
            home += tree - mid

    if home < m:
        e = mid - 1
    else:
        max_len = max(max_len, mid)
        s = mid + 1

print(max_len)