import sys
input = sys.stdin.readline

test = int(input())
seat = [0] * 101
guest = list(map(int, input().split()))
cnt = 0

for i in range(test):
    if seat[guest[i]] != 0:
        cnt += 1
    else:
        seat[guest[i]] = 1

print(cnt)