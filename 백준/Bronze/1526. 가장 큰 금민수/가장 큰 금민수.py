import sys
input = sys.stdin.readline

n = int(input())

while n > 3:
    s = str(n)
    cnt = 0

    if s.count("4") > 0:
        cnt += s.count("4")
    if s.count("7") > 0:
        cnt += s.count("7")
    
    if cnt == len(s):
        print(s)
        break

    n -= 1