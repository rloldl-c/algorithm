import sys
input = sys.stdin.readline

n, m = map(int, input().split())
group1 = []
group2 = []

for _ in range(n):
    group1.append(input().strip())

for _ in range(m):
    group2.append(input().strip())

group1 = set(group1)
group2 = set(group2)

ans = sorted(list(group1 & group2))

print(len(ans), *ans, sep="\n")