test = int(input())

for i in range(test):
    num = int(input())
    origin = ""

    for j in range(num):
        s, n = input().split()
        origin += s * int(n)

    print(f"#{i+1}")
    for j in range(len(origin)):
        print(origin[j], end="")
        if (j+1) % 10 == 0:
            print()
    print()