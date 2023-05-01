import sys
input = sys.stdin.readline

n = int(input())
start = [input().strip() for _ in range(n)]
end = [input().strip() for _ in range(n)]
cnt = 0
check = [False] * n

for i in range(n):
    for j in range(n):
        if start[i] == end[j]:
            check[j] = True
            break
        else:
            if not check[j]:
                cnt += 1
                check[j] = True

print(cnt)