import sys
input = sys.stdin.readline

num = int(input())
d = [0] * num
d[0] = 1

if num > 1:
    d[1] = 2

    for i in range(2, num):
        d[i] = (d[i-1] + d[i-2]) % 15746

print(d[num-1])