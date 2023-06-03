import sys
input = sys.stdin.readline

n = int(input())
num = []
tmp = ''

for _ in range(n):
    s = input().strip()

    for i in s:
        if i in '0123456789':
            tmp += i
        else:
            if tmp:
                num.append(int(tmp))
                tmp = ''
        
    if tmp:
        num.append(int(tmp))

    tmp = ''

print('\n'.join(map(str, sorted(num))))