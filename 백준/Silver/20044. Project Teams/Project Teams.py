import sys
input = sys.stdin.readline

team = int(input())
stu = sorted(list(map(int, input().split())))
ans = int(1e9)

for i in range(team):
    ans = min(ans, stu[i] + stu[-(i+1)])

print(ans)