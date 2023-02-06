import sys
input = sys.stdin.readline

n = int(input())
num = 1
for i in range(2, n+1):
    num *= i

cnt = 0
reverse_n = str(num)[::-1]

for i in reverse_n:
    if i == "0":
        cnt += 1
    else:
        break

print(cnt)