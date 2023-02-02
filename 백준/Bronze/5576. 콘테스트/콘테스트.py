import sys
input = sys.stdin.readline

w = []
k = []

for _ in range(10):
    w.append(int(input()))

for _ in range(10):
    k.append(int(input()))

w = sorted(w, reverse=True)
k = sorted(k, reverse=True)

print(sum(w[0:3]), sum(k[0:3]))