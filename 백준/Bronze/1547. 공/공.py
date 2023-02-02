import sys
input = sys.stdin.readline

n = int(input())
cups = [1, 2, 3]

for _ in range(n):
    chg1, chg2 = map(int, input().split())

    chg1 = cups.index(chg1)
    chg2 = cups.index(chg2)

    tmp = cups[chg1]
    cups[chg1] = cups[chg2]
    cups[chg2] = tmp


print(cups[0])