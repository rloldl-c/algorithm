import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))
res = []

for i in range(n-1, 0, -1):
    if num[i] < num[i-1]:
        for j in range(n-1, 0, -1):
            if num[j] < num[i-1]:
                num[j], num[i-1] = num[i-1], num[j]
                res = num[:i] + sorted(num[i:], reverse=True)
                break
        
        if res:
            break

if res:
    print(*res)
else:
    print(-1)
