import sys

num = int(sys.stdin.readline().strip())
age = [[] for i in range(201)]
cnt = [0 for i in range(201)]

for i in range(num):
    a, b = sys.stdin.readline().split()
    a = int(a)
    age[a].append(b)
    cnt[a] += 1

for i in range(201):
    for j in range(cnt[i]):
        print(i, age[i][j])