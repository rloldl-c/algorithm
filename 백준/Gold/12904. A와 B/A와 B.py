import sys
input = sys.stdin.readline

s = input().strip()
t = input().strip()

while True:
    if t[-1] == 'A':
        t = t[:-1]
    else:
        t = t[:-1]
        t = t[::-1]

    if t == s or len(t) == 1:
        break

if s == t:
    print(1)
else:
    print(0)