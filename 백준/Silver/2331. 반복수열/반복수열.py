import sys
input = sys.stdin.readline

n, m = input().split()
stack = []
res = []
visited = [False] * 354294

stack.append(n)
res.append(int(n))

while stack:
    sum_ = 0
    tmp = stack.pop()

    if visited[int(tmp)] == True:
        res_n = int(tmp)
        break

    visited[int(tmp)] = True
    for i in tmp:
        sum_ += int(i) ** int(m)

    stack.append(str(sum_))
    res.append(sum_)

print(res.index(res_n))