import sys
input = sys.stdin.readline

num = int(input())
hour = [[0]*2 for i in range(num)]
cnt = 1

for i in range(num):
    s, e = map(int, input().split())
    hour[i][0] = s
    hour[i][1] = e

hour = sorted(hour)
hour = sorted(hour, key=lambda x: x[1])

now = hour[0]
cnt = 1

for i in range(1, num):
    if hour[i][0] >= now[0] and hour[i][0] >= now[1]:
        now = hour[i]
        cnt += 1

print(cnt)