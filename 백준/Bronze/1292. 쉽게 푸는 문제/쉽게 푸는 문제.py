a, b = map(int, input().split())
s = []
total = 0

if a == 1 and b == 1:
    print(1)
else:
    for i in range(b+1):
        if i != 0:
            for j in range(i):
                s.append(i)

    print(sum(s[a-1:b]))