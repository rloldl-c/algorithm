import sys

num = int(sys.stdin.readline().strip())
sticks = [0 for i in range(num)]
cnt = 1

for i in range(num):
    sticks[i] = int(sys.stdin.readline().strip())

last = sticks[num-1]

for i in reversed(range(num)):
    if sticks[i] > last:
        cnt += 1
        last = sticks[i]
        
print(cnt)