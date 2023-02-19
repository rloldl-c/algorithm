import sys
input = sys.stdin.readline

n = input().strip()
cnt = 0
tmp = 0
ans = 0

while True:
    if len(n) != 1:
        cnt += 1

    for i in n:
        tmp += int(i)

    if tmp // 10 == 0:
        ans = tmp
        break
    else:
        n = str(tmp)
        tmp = 0

print(cnt)
print("YES" if tmp % 3 == 0 else "NO")