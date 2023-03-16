import sys
input = sys.stdin.readline

n = int(input())
tmp = n
cnt = 0
num = 1 # 몇자리 수인지

for i in range(8):
    if tmp >= 10:
        num += 1
        tmp //= 10

if num > 1:
    for i in range(1, num+1):
        if i == num:
            cnt += i * (n - 10**(i-1) + 1)
        else:
            cnt += 9 * i * 10**(i-1)
else:
    cnt = n

print(cnt)