import sys
input = sys.stdin.readline

test = int(input())

for _ in range(test):
    a, b = map(int, input().split())
    print(a+b)