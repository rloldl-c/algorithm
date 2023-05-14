import sys
input = sys.stdin.readline

n, m = map(int, input().split())
memo = dict()
cnt = n

for _ in range(n):
    memo[input().strip()] = 1

for _ in range(m):
    blog = input().split(',')
    blog[-1] = blog[-1].strip()

    for keyword in blog:
        if keyword in memo and memo[keyword] != 0:
            memo[keyword] -= 1
            cnt -= 1

    print(cnt)