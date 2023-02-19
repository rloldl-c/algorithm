import sys
input = sys.stdin.readline

n = input().strip()
cnt = 0
tmp = 0
ans = 0

while True:
    if len(n) != 1:
        cnt += 1

    n = str(sum(map(int, n)))

    if len(n) == 1:
        ans = n
        break

print(cnt)
print("YES" if int(n) % 3 == 0 else "NO")