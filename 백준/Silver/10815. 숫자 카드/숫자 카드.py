import sys
input = sys.stdin.readline

num = int(input())
sk_card = sorted(list(map(int, input().split())))
m = int(input())
card = list(map(int, input().split()))
ans = [0 for i in range(m)]

for i in range(len(card)):
    is_in = False
    start = 0
    end = len(sk_card)-1

    while start <= end:
        mid = (start + end) // 2

        if sk_card[mid] == card[i]:
            is_in = True
            break
        elif sk_card[mid] > card[i]:
            end = mid - 1
        else:
            start = mid + 1

    ans[i] = int(is_in)

print(*ans)