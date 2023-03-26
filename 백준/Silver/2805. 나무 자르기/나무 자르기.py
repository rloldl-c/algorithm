import sys
input = sys.stdin.readline

n, target = map(int, input().split())
tree = sorted(list(map(int, input().split())))
s = 1
e = max(tree)
ans = 0

while s <= e:
    mid = int((s + e) / 2)
    tmp = 0 # 상근이가 가져갈 나무
    
    for i in tree:
        if i > mid:
            tmp += i - mid

    if tmp < target:
        e = mid - 1
    else:
        ans = mid
        s = mid + 1

print(ans)