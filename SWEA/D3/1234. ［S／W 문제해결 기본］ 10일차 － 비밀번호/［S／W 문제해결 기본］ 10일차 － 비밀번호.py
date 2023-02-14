for t in range(10):
    num = list(map(str, input().split()))
    password = list(num[1])
    tmp = []

    for n in password:
        if tmp and n == tmp[-1]:
            tmp.pop()
        else:
            tmp.append(n)

    print("#", t+1, sep="", end=" ")
    print(*tmp, sep="")