import sys
input = sys.stdin.readline

n, m = input().split()

res = int(n[::-1]) + int(m[::-1])

print(int(str(res)[::-1]))