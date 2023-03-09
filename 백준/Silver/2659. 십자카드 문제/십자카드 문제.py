import sys
input = sys.stdin.readline

def cross_num(s):
    m = int(1e9)

    for i in range(4):
        tmp = ''
        for j in range(4):
            tmp += s[(i+j)%4]

        m = min(m, int(tmp))
    
    if int(s) == m:
        return True
    else:
        return False


num = list(input().split())
m = int(1e9)
cnt = 0

for i in range(4):
    tmp = ''
    for j in range(4):
        tmp += num[(i+j)%4]

    m = min(m, int(tmp))

for i in range(1111, m+1):
    if '0' not in str(i):
        if cross_num(str(i)):
            cnt += 1

print(cnt)