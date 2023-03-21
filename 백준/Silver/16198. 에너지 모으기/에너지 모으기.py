import sys
input = sys.stdin.readline

def recursion(energy):
    global ans

    if len(num) == 2:
        ans = max(ans, energy)
        return
    else:
        for i in range(1, len(num)-1):
            tmp = num[i-1]*num[i+1]
            now = num[i]
            num.pop(i)
            recursion(energy + tmp)
            num.insert(i, now)


n = int(input())
num = list(map(int, input().split()))
ans = 0

recursion(0)

print(ans)