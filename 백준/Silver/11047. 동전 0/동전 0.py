import sys

input = sys.stdin.readline

num, total = map(int, input().split())
coin = []

for i in range(num):
    coin.append(int(input()))

coin.sort(reverse=True)
idx = 0
cnt = 0

while True:
    if total < coin[idx]:
        idx += 1
        continue

    cnt += total // coin[idx]
    total %= coin[idx]

    if total == 0:
        break

print(cnt)