import sys

test = int(sys.stdin.readline())

for i in range(test):
    h, w, n = map(int, sys.stdin.readline().split())
    floor = 0
    num = 0
    
    if n%h == 0:
        floor = h * 100
        num = n // h

    else:
        floor = (n%h) * 100
        num = (n//h) + 1

    print(floor + num)