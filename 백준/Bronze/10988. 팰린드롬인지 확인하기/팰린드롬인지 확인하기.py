s = input()
res = 0

if len(s) == 1:
    res = 1

for i in range(len(s)//2):
    if s[i] != s[len(s)-1-i]:
        res = 0
        break
    else:
        res = 1

print(res)