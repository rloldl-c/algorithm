import sys
input = sys.stdin.readline

s = list(input().strip())
res = ""
tmp = ""
idx = 0

while idx != len(s):
    if s[idx] == "<":
        res += tmp[::-1]
        tmp = ""
        while s[idx] != ">":
            res += s[idx]
            idx += 1

    elif s[idx] == ">":
        res += s[idx]
        idx += 1

    elif s[idx] == " ":
        res += tmp[::-1]
        tmp = ""
        res += " "
        idx += 1
    
    else:
        tmp += s[idx]
        idx += 1

res += tmp[::-1]
print(res)