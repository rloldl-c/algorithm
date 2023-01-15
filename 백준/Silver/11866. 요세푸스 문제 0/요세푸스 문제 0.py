import sys

num, k = map(int, sys.stdin.readline().split())
numbers = [i+1 for i in range(num)]
clone = numbers
cnt = 1
res = []

while True:
    if cnt % k == 0:
        res.append(clone.pop(0))
    else:
        tmp = clone.pop(0)
        clone.append(tmp)
    
    cnt += 1

    if len(clone) == 0:
        break

print("<", end="")
print(*res, sep=", ", end="")
print(">")