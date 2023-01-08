import sys

n = int(sys.stdin.readline().strip())

num = 1
cnt = 1

while True:
    if n == 1:
        print(1)
        break
    else:
        num += 6 * cnt
        if num >= n:
            print(cnt+1)
            break

        else:
            cnt += 1

