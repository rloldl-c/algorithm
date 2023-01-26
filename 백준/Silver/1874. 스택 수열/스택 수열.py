import sys

input = sys.stdin.readline

num = int(input())
cnt = 1
stack = []
res = []

for i in range(num):
    n = int(input())

    while cnt <= n:
        stack.append(cnt)
        res.append("+")
        cnt += 1
    
    a = stack.pop()

    if a == n:
        res.append("-")
    else:
        res = []
        break

if len(res) != 0:
    print(*res, sep="\n")
else:
    print("NO")