import sys
input = sys.stdin.readline

n, m = map(int, input().split())
apple = int(input())
target = [0] * apple
cnt = 0
start = 1
end = m

for i in range(apple):
    target[i] = int(input())

for i in range(apple):
    if start <= target[i] <= end:
        continue
    elif start > target[i]:
        cnt += start - target[i]
        start = target[i]
        end = start + m - 1
    elif end < target[i]:
        cnt += target[i] - end
        end = target[i]
        start = end - m + 1

print(cnt)