import sys
input = sys.stdin.readline

test = int(input())

seq = [0] * 101
seq[0] = seq[1] = seq[2] = 1

for i in range(3, 101):
    seq[i] = seq[i-3] + seq[i-2]

for _ in range(test):
    n = int(input())
    print(seq[n-1])