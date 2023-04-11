import sys
input = sys.stdin.readline

k = int(input()) # 사람 수
n = int(input()) # 놓아야 하는 가로 줄 수
end = list(input().strip())
start = sorted(end)
ladder = [list(input().strip()) for _ in range(n)]
left = []
right = []

for i in range(n):
    if ladder[i] == ["?" for _ in range(k-1)]:
        left = right
        right = []
        continue
    
    right.append(ladder[i])

while left:
    tmp = left.pop(0)

    for i in range(k-1):
        if tmp[i] == '-':
            start[i], start[i+1] = start[i+1], start[i]

while right:
    tmp = right.pop()

    for i in range(k-1):
        if tmp[i] == '-':
            end[i], end[i+1] = end[i+1], end[i]

ans = ['*' for _ in range(k-1)]
for i in range(k-1):
    if start[i] == end[i+1] and start[i+1] == end[i]:
        ans[i] = '-'
        start[i], start[i+1] = start[i+1], start[i]

if start == end:
    print(*ans, sep='')
else:
    print('x'*(k-1))