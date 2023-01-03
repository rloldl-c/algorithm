h, m = map(int, input().split())

if m - 45 < 0:
    h -= 1
    if h < 0:
        h = 23
    print(h,  m - 45 + 60)
else:
    print(h, m - 45)