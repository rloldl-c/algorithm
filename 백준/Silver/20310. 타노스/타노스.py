import sys
input = sys.stdin.readline

s = input().strip()
cnt0 = s.count('0')//2
cnt1 = s.count('1')//2
ans = ''

while cnt0 > 0:
    if cnt0 != 0:
        ans += '0'
        cnt0 -= 1

ans += '1' * int(cnt1)

print(ans)