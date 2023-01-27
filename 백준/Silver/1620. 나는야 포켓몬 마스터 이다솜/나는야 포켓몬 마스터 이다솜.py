import sys
input = sys.stdin.readline

book, num = map(int, input().split())
pockemon = {}

for i in range(book):
    pockemon[input().strip()] = i+1

pockemon_name = list(pockemon.keys())

for _ in range(num):
    s = input().strip()

    if ord(s[0]) > 64:
        print(pockemon.get(s))
    elif 48 < ord(s[0]) or ord(s[0]) > 58:
        print(pockemon_name[int(s)-1])