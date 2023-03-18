import sys
input = sys.stdin.readline

def sumNum(total, idx, cnt, sum_):
    global ans

    if cnt == total:
        if sum_ == s:
            ans += 1

        return

    for i in range(idx, n):
        if i not in tmp:
            tmp.append(i)
            sumNum(total, i, cnt+1, sum_+num[i])
            tmp.pop()



n, s = map(int, input().split())
num = list(map(int, input().split()))
tmp = []
ans = 0

for i in range(1, n+1):
    sumNum(i, 0, 0, 0)


print(ans)

