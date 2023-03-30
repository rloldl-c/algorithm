import sys
input = sys.stdin.readline

n, k = map(int, input().split())
s = 0
e = n

while s <= e:
    mid = int((s+e) / 2)
    tmp = n - mid

    if (mid+1) * (tmp+1) > k:
        s = mid + 1
    elif (mid+1) * (tmp+1) < k:
        e = mid - 1
    else:
        print("YES")
        break
else:
    print("NO")