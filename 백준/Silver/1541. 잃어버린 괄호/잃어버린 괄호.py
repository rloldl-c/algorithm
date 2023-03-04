import sys
input = sys.stdin.readline

s = input().strip()
tmp = ""
num = []
ans = []
minus = 0

for i in range(len(s)):
    if s[i] not in "+-":
        tmp += s[i]
    else:
        num.append(int(tmp))
        num.append(s[i])
        tmp = ""

    if i == len(s)-1:
        num.append(int(tmp))

for i in range(len(num)):
    if num[i] == "-":
        minus += 1

    if type(num[i]) == int:
        if minus != 0:
            ans.append(-1*num[i])
        else:
            ans.append(num[i])

print(sum(ans))