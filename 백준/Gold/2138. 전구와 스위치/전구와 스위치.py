import sys, copy
input = sys.stdin.readline

def onoff(idx):
    if idx == 0:
        for i in range(2):
            tmp[i] = 1 - tmp[i]
    
    elif idx == n-1:
        for i in range(n-2, n):
            tmp[i] = 1 - tmp[i]
    else:
        for i in range(idx-1, idx+2):
            tmp[i] = 1 - tmp[i]
    return

n = int(input())
now = list(map(int, input().strip()))
tmp = copy.deepcopy(now)
bulb = list(map(int, input().strip()))
ans = int(1e9)
cnt = 0

# 첫 번째 전구 누르지 않고 시작
for i in range(1, n):
    if tmp[i-1] != bulb[i-1]:
        cnt += 1
        onoff(i)

if tmp == bulb:
    ans = min(ans, cnt)

cnt = 1
tmp = copy.deepcopy(now)
onoff(0)
# 첫번째 전구를 누르고 시작
for i in range(1, n):
    if tmp[i-1] != bulb[i-1]:
        cnt += 1
        onoff(i)

if tmp == bulb:
    ans = min(ans, cnt)

if ans == int(1e9):
    print(-1)
else:
    print(ans)