import sys
input = sys.stdin.readline

test = int(input())
coin = [25, 10, 5, 1]

for i in range(test):
    money = int(input())
    res = [0, 0, 0, 0]
    idx = 0

    while money != 0:
        if money >= coin[idx]:
            res[idx] = money // coin[idx]
            money -= coin[idx] * res[idx]
        else:
            idx += 1

    print(*res)