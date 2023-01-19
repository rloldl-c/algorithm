import sys

num = int(sys.stdin.readline().strip())
cnt = 2

if num == 1:
    print()
else:
    while num != 1:
        if num % cnt == 0:
            num //= cnt
            print(cnt)
        else:
            cnt += 1
