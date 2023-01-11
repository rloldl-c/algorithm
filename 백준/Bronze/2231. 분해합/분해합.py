num = int(input())

for i in range(1, num+1):
    add = i
    res = i

    while i > 0:
        add += i % 10
        i //= 10

    if add == num:
        break

if res != num:
    print(res)
else:
    print(0)