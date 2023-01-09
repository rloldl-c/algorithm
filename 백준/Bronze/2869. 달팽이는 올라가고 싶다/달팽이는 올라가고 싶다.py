import sys

up, down, length = map(int, sys.stdin.readline().split())
day = (length - down ) // (up - down)

if (length - down ) % (up - down) == 0:
    print(day)
else:
    print(day+1)