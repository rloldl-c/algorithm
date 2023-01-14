import sys

num = int(sys.stdin.readline().strip())
cnt = 0
n = 666

while True:
    if str(n).count("666") >= 1:
        cnt += 1
        if cnt == num:
            break
    
    n += 1

print(n)