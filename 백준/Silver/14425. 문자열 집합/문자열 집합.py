import sys

n, m = map(int, input().split())

s_list = []
cnt = 0

for _ in range(n):
    s_list.append(input().strip())

s_list = set(s_list)

for _ in range(m):
    s = input().strip()
    
    if s in s_list:
        cnt += 1

print(cnt)

