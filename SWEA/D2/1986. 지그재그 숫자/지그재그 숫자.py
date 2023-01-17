test = int(input())

for i in range(test):
    num = int(input())
    total = 0

    for j in range(1, num+1):
        if j % 2 == 0:
            total -= j
        else:
            total += j

    print(f"#{i+1} {total}")