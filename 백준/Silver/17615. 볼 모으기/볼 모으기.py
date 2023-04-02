import sys
input = sys.stdin.readline

n = int(input())
ball = list(input().strip())
red = ball.count('R')
blue = n - red
ans = min(red, blue)

cnt = 0
for i in range(n):
    if ball[0] != ball[i]:
        break
    cnt += 1

if ball[0] == "R":
    ans = min(ans, red - cnt)
else:
    ans = min(ans, blue - cnt)

cnt = 0
for i in range(n-1, -1, -1):
    if ball[-1] != ball[i]:
        break
    cnt+=1

if ball[-1] == "R":
    ans = min(ans, red - cnt)
else:
    ans = min(ans, blue - cnt)

print(ans)