import sys
input = sys.stdin.readline

def password(start, n):
    global tmp

    if n == l:
        res.add(''.join(tmp))
            
        return

    for i in range(start, c):
        tmp.append(char[i])
        password(i+1, n+1)
        tmp.pop()
    


l, c = map(int, input().split())
char = sorted(list(input().split()))
tmp = []
res = set()
password(0, 0)

res = sorted(res)

for i in res:
    cnt1 = 0
    cnt2 = 0
    for j in i:
        if j in 'aeiou':
            cnt1 += 1
        else:
            cnt2 += 1

    if cnt1 > 0 and cnt2 > 1:
        print(i)