import sys
input = sys.stdin.readline

oe, os, om = map(int, input().split())
e = s = m = 1
year = 1

while True:
    if e == oe and s == os and m == om:
        break

    e += 1
    s += 1
    m += 1
    
    if e > 15:
        e = 1
    
    if s > 28:
        s = 1

    if m > 19:
        m = 1

    year += 1

print(year)