import sys
input = sys.stdin.readline

n = int(input())
request = list(map(int, input().split()))
total = int(input())

limit = []

request.sort()

if sum(request) > total:
    s = 1
    e = request[-1]
    
    while s <= e:
        tmp = 0
        mid = (s + e) // 2

        for budget in request:
            if budget > mid:
                tmp += mid
            else:
                tmp += budget

        if tmp > total:
            e = mid - 1
        else:
            limit.append(mid)
            s = mid + 1

    print(max(limit))

else:
    print(max(request))