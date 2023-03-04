import sys
input = sys.stdin.readline

s = input().strip()
tmp = ""
cnt = 0
ans = 0

for i in range(len(s)):
    if s[i] not in "+-":
        tmp += s[i]
    else:
        if not cnt:
            ans += int(tmp)
        else:
            ans -= int(tmp)

        tmp = ""

    if s[i] == "-":
        cnt += 1

if not cnt:
    ans += int(tmp)
else:
    ans -= int(tmp)

print(ans)