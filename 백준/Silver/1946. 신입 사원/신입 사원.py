import sys
input = sys.stdin.readline

test = int(input())
for _ in range(test):
    n = int(input())
    score = [0] * (n+1)

    for _ in range(n):
        a, b = map(int, input().split())
        score[a] = b

    cnt = 1
    now = score[1]

    for i in score[2:]:
        if now > i:
            cnt += 1
            now = i

    print(cnt)