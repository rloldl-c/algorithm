import sys
input = sys.stdin.readline

a, b = input().split()
cnt = 1

while True:
    if int(a) >= int(b):
        break

    if b[-1] == '1':
        cnt += 1
        b = b[:-1]

    elif int(b) % 2 == 0:
        cnt += 1
        b = str(int(b) // 2)

    else:
        break

if a != b:
    cnt = -1

print(cnt)