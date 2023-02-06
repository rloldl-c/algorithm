import sys
input = sys.stdin.readline

max_ = 0
train = 0

for _ in range(4):
    n, m = map(int, input().split())
    train += m - n
    max_ = max(max_, train)

print(max_)